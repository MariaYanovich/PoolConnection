package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUpdateTourPageCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetUpdateTourPageCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(JspParameterType.TOUR_ID);
        request.getSession().setAttribute(JspParameterType.TOUR_ID, id);
        try {
            request.getSession().setAttribute(JspParameterType.TOUR, ServiceFactory.getInstance().getTourService().findTour(Integer.parseInt(id)));
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.UPDATE_TOUR_PAGE.getAddress();
    }
}
