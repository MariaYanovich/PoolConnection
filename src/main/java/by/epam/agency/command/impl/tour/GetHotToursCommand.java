package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetHotToursCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetHotToursCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Tour> tours = new ArrayList<>();
        try {
            tours = ServiceFactory.getInstance().getTourService().getHotTours();
        } catch (ServiceException e) {
            LOGGER.error(Message.GET_HOT_TOURS_COMMAND_ERROR, e);
        }
        request.getSession().setAttribute(SessionAttribute.TOURS, tours);
        return PageType.TOURS_LIST_PAGE.getAddress();
    }
}
