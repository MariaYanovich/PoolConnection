package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.CommandType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteClientCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteClientCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServiceFactory.getInstance().getUserService().
                    deleteClient(((User) request.getSession().getAttribute(SessionAttribute.USER)).getUserId());
            Command signOut = CommandFactory.getInstance().
                    getCommand(CommandType.SIGN_OUT.toString());
            return signOut.execute(request, response);
        } catch (ServiceException e) {
            LOGGER.error(Message.DELETE_CLIENT_COMMAND_ERROR, e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
