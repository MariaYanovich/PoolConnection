package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.CommandType;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTourCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteTourCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServiceFactory.getInstance().getTourService().
                    deleteTour(Integer.parseInt(request.
                            getParameter(JspParameterType.TOUR_ID)));
            Command getToursList = CommandFactory.getInstance().
                    getCommand(CommandType.GET_TOURS_LIST.toString());
            return getToursList.execute(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
