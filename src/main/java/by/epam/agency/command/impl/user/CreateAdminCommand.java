package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAdminCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CreateAdminCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            createAdmin(request);
            return PageType.HOME_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(Message.CREATE_ADMIN_COMMAND_ERROR, e);
        }
        return PageType.CREATE_ADMIN_PAGE.getAddress();
    }

    private void createAdmin(HttpServletRequest request) throws ServiceException {
        String login = request.getParameter(JspParameterType.LOGIN);
        String password = request.getParameter(JspParameterType.PASSWORD);
        String name = request.getParameter(JspParameterType.NAME);
        String surname = request.getParameter(JspParameterType.SURNAME);
        String phone = request.getParameter(JspParameterType.PHONE);
        ServiceFactory.getInstance().getUserService().createAdmin(login, password, name, surname, phone);
    }
}
