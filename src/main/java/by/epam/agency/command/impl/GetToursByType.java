package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetToursByType implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetToursByType.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(JspParameterType.TOUR_TYPE_ID);
        List<Tour> tours = new ArrayList<>();
        try {
            tours = ServiceFactory.getInstance().getTourService().getToursByTourTypeId(Integer.parseInt(id));
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        request.getSession().setAttribute(JspParameterType.TOURS, tours);
        return PageType.TOURS_LIST_PAGE.getAddress();
    }
}
