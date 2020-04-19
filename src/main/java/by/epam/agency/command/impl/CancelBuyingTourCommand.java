package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Order;
import by.epam.agency.entity.Tour;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelBuyingTourCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CancelBuyingTourCommand.class.getName());

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int orderId = Integer.parseInt(request.getParameter(JspParameterType.ORDER_ID));
            Order order = serviceFactory.getOrderService().findOrderById(orderId);
            User user = serviceFactory.getUserService().findUserById(order.getUser().getUserId());
            serviceFactory.getUserService().returnMoney(user, order.getPrice());
            Tour tour = serviceFactory.getTourService().findTourById(order.getTour().getTourId());
            serviceFactory.getTourService().returnTour(tour, order.getNumber());
            serviceFactory.getOrderService().deleteOrder(orderId);
            return PageType.USER_INFO_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}