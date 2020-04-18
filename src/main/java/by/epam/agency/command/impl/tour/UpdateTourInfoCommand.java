package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.CommandType;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class UpdateTourInfoCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UpdateTourInfoCommand.class.getName());

    public static void updateTour(HttpServletRequest request, Tour tour) throws ServiceException {
        tour.setCost(Double.parseDouble(request.getParameter(JspParameterType.COST)));
        tour.setDays(Integer.parseInt(request.getParameter(JspParameterType.DAYS)));
        tour.setPlaces(Integer.parseInt(request.getParameter(JspParameterType.PLACES)));
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
        String id = (String) request.getSession().getAttribute(JspParameterType.TOUR_ID);
        try {
            Tour tour = ServiceFactory.getInstance().getTourService().findTour(Integer.parseInt(id));
            tour.setTourId(Integer.parseInt(id));
            updateTour(request, tour);
            ServiceFactory.getInstance().getTourService().updateTour(tour);
            Command getToursList = CommandFactory.getInstance().getCommand(CommandType.GET_TOURS_LIST.toString());
            return getToursList.execute(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
