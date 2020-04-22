package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.command.util.CommandUtil;
import by.epam.agency.entity.Order;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyTourCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(BuyTourCommand.class.getName());

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Order order = new Order();
            initializeOrder(order, request);
            if (order.getUser().getCash() >= order.getPrice()) {
                buyTourActions(order);
                new CommandUtil().setOrderSessionAttributes(request, order.getUser(), order.getTour());
                return new GetAllOrdersCommand().execute(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.error(Message.BUY_TOUR_COMMAND_ERROR, e);
        }
        return PageType.NO_MONEY_PAGE.getAddress();
    }

    private void initializeOrder(Order order, HttpServletRequest request) throws ServiceException {
        order.setUser(serviceFactory.getUserService().findUserById(((User) request.getSession().
                getAttribute(SessionAttribute.USER)).getUserId()));
        order.setTour(serviceFactory.getTourService().
                findTourById(Integer.parseInt((String) request.getSession().
                        getAttribute(SessionAttribute.TOUR_ID))));
        order.setNumber(Integer.parseInt((String) request.getSession().
                getAttribute(SessionAttribute.TOUR_NUMBER)));
        double price = countPriceWithDiscount(order);
        order.setPrice(price);
    }

    private double countPriceWithDiscount(Order order) {
        return order.getUser().getDiscount().getDiscountSize() * order.getTour().getCost() * order.getNumber();
    }

    private void buyTourActions(Order order) throws ServiceException {
        serviceFactory.getUserService().takeMoney(order.getUser(), order.getPrice());
        serviceFactory.getTourService().buyTour(order.getTour(), order.getNumber());
        serviceFactory.getOrderService().createOrder(order);
        serviceFactory.getOrderService().updateUserDiscount(order.getUser());
    }
}

