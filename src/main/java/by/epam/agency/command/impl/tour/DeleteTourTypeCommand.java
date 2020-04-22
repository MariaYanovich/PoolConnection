package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTourTypeCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger(DeleteTourTypeCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServiceFactory.getInstance().getTourTypeService().
                    deleteTourTypeById(Integer.parseInt(request.getParameter(JspParameterType.TOUR_TYPE)));
            request.getSession().setAttribute(SessionAttribute.TOUR_TYPES,
                    ServiceFactory.getInstance().getTourTypeService().getAllTourTypes());
        } catch (ServiceException e) {
            LOGGER.error(Message.DELETE_TOUR_TYPE_COMMAND_ERROR, e);
        }
        return PageType.SERVICE_PAGE.getAddress();
    }
}
