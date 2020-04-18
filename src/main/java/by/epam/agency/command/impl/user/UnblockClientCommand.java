package by.epam.agency.command.impl.user;

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


public class UnblockClientCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UnblockClientCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(JspParameterType.USER_ID);
        try {
            ServiceFactory.getInstance().getUserService().unblockClient(Integer.parseInt(id));
            Command getUsersList = CommandFactory.getInstance().getCommand(CommandType.GET_USERS_LIST.toString());
            return getUsersList.execute(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
