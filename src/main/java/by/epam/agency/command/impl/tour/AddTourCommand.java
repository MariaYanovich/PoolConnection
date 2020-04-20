package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class AddTourCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AddTourCommand.class.getName());

    private static void initializeTour(HttpServletRequest request, Tour tour) throws ServiceException {
        tour.setName(request.getParameter(JspParameterType.TOUR_NAME));
        tour.setCost(Double.parseDouble(request.getParameter(JspParameterType.COST)));
        tour.setDays(Integer.parseInt(request.getParameter(JspParameterType.DAYS)));
        tour.setPlaces(Integer.parseInt(request.getParameter(JspParameterType.PLACES)));
        try {
            tour.setImage(request.getPart(JspParameterType.IMAGE).getInputStream());
        } catch (IOException | ServletException e) {
            LOGGER.error(e);
        }
        tour.setDepartureDate(Date.valueOf(request.getParameter(JspParameterType.DEPARTURE_DATE)));
        tour.setTransport(ServiceFactory.getInstance().getTransportService().
                findTransportById(Integer.parseInt(request.getParameter(JspParameterType.TOUR_TRANSPORT))));
        tour.setCity(ServiceFactory.getInstance().getCityService().
                findCityById(Integer.parseInt(request.getParameter(JspParameterType.TO_CITY))));
        tour.setDepartureCity(ServiceFactory.getInstance().getCityService().
                findCityById(Integer.parseInt(request.getParameter(JspParameterType.DEPARTURE_CITY))));
        tour.setTourType(ServiceFactory.getInstance().getTourTypeService().
                findTourTypeById(Integer.parseInt(request.getParameter(JspParameterType.TOUR_TYPE))));
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Tour tour = new Tour();
            initializeTour(request, tour);
            ServiceFactory.getInstance().getTourService().addTour(tour);
            request.getSession().setAttribute(JspParameterType.TOURS,
                    ServiceFactory.getInstance().getTourService().getAllTours());
        } catch (ServiceException e) {
            LOGGER.error(e);
            return PageType.ADD_TOUR_PAGE.getAddress();
        }
        return PageType.TOURS_LIST_PAGE.getAddress();
    }
}
