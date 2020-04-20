package by.epam.agency.command.util;

import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.entity.*;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CommandUtil {
    private static final Logger LOGGER = LogManager.getLogger(CommandUtil.class.getName());

    public void initializeTourParameters(HttpServletRequest request) {
        List<Tour> tours = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        List<TourType> tourTypes = new ArrayList<>();
        List<Transport> transports = new ArrayList<>();
        try {
            tours = ServiceFactory.getInstance().getTourService().getAllTours();
            cities = ServiceFactory.getInstance().getCityService().getAllCities();
            tourTypes = ServiceFactory.getInstance().getTourTypeService().getAllTourTypes();
            transports = ServiceFactory.getInstance().getTransportService().getAllTransports();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        request.getSession().setAttribute(JspParameterType.TRANSPORTS, transports);
        request.getSession().setAttribute(JspParameterType.TOURS, tours);
        request.getSession().setAttribute(JspParameterType.CITIES, cities);
        request.getSession().setAttribute(JspParameterType.TOUR_TYPES, tourTypes);
    }

    public void setSessionAttributesForUserAuthorize(HttpSession session, User user) {
        session.setAttribute(JspParameterType.LOGIN, user.getLogin());
        session.setAttribute(JspParameterType.PASSWORD, user.getPassword());
        session.setAttribute(JspParameterType.USER_ID, user.getUserId());
        session.setAttribute(JspParameterType.NAME, user.getName());
        session.setAttribute(JspParameterType.SURNAME, user.getSurname());
        session.setAttribute(JspParameterType.DISCOUNT, user.getDiscount());
        session.setAttribute(JspParameterType.CASH, user.getCash());
        session.setAttribute(JspParameterType.PHONE, user.getPhone());
        session.setAttribute(JspParameterType.ROLE, user.getRole());
    }

    public void setOrderSessionAttributes(HttpServletRequest request, User user, Tour tour) {
        request.getSession().setAttribute(JspParameterType.TOUR_NUMBER, tour.getPlaces());
        request.getSession().setAttribute(JspParameterType.CASH, user.getCash());
        request.getSession().setAttribute(JspParameterType.DISCOUNT, user.getDiscount());
    }

    public void setTourSessionAttribute(HttpServletRequest request) {
        String tourId = request.getParameter(JspParameterType.TOUR_ID);
        request.getSession().setAttribute(JspParameterType.TOUR_ID, tourId);
        try {
            request.getSession().setAttribute(JspParameterType.TOUR,
                    ServiceFactory.getInstance().getTourService().findTourById(Integer.parseInt(tourId)));
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
    }
}
