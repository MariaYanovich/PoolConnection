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

public class BuyTourCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(BuyTourCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Order order = new Order();
        try {
            User user = ServiceFactory.getInstance().getUserService().findUserById(
                    (Integer) request.getSession().getAttribute(JspParameterType.USER_ID));
            Tour tour = ServiceFactory.getInstance().getTourService().findTour(Integer.parseInt((String) request.getSession().getAttribute(JspParameterType.TOUR_ID)));
            int numberOfTours = Integer.parseInt((String) request.getSession().getAttribute(JspParameterType.TOUR_NUMBER));
            order.setUser(user);
            order.setTour(tour);
            order.setNumber(numberOfTours);
            double price = countPriceWithDiscount(user, tour, numberOfTours);
            order.setPrice(price);
            if (user.getCash() >= price) {
                ServiceFactory.getInstance().getUserService().takeMoney(user, price);
                ServiceFactory.getInstance().getTourService().buyTour(tour, numberOfTours);
                ServiceFactory.getInstance().getOrderService().createOrder(order);
            }
            request.getSession().setAttribute(JspParameterType.TOUR_NUMBER, tour.getPlaces());
            request.getSession().setAttribute(JspParameterType.CASH, user.getCash());
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.USER_INFO_PAGE.getAddress();
    }


    private double countPriceWithDiscount(User user, Tour tour, int numberOfTours) {
        return user.getDiscount().getDiscountSize() * tour.getCost() * numberOfTours;
    }

}

