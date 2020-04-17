package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.City;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SearchToursByParameters implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SearchToursByParameters.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Tour> tours = new ArrayList<>();
        try {
            City city = ServiceFactory.getInstance().getCityService().
                    findCityById(Integer.parseInt(request.getParameter(JspParameterType.TO_CITY)));
            LOGGER.debug(city);
            Date date = Date.valueOf(request.getParameter(JspParameterType.DEPARTURE_DATE));
            LOGGER.debug(date);
            int days = Integer.parseInt(request.getParameter(JspParameterType.DAYS));
            LOGGER.debug(days);
            float cost = Float.parseFloat(request.getParameter(JspParameterType.COST));
            LOGGER.debug(cost);
            tours = ServiceFactory.getInstance().getTourService().searchToursByParameters(city, date, days, cost);
            LOGGER.debug(tours);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        request.getSession().setAttribute(JspParameterType.TOURS, tours);
        return PageType.TOURS_LIST_PAGE.getAddress();
    }
}
