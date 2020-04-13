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
import java.util.List;

public class GetHotToursCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetHotToursCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Tour> listResults = null;
        try {
            listResults = ServiceFactory.getInstance().getTourService().getHotTours();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        request.setAttribute(JspParameterType.TOURS, listResults);
        return PageType.HOT_TOURS_PAGE.getAddress();
    }
}
