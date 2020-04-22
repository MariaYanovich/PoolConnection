package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAdminCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UpdateAdminCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User admin = (User) request.getSession().getAttribute(SessionAttribute.USER);
        try {
            initializeAdminWithNewParameters(request, admin);
            ServiceFactory.getInstance().getUserService().updateAdmin(admin);
            request.getSession().setAttribute(SessionAttribute.USER, admin);
            return PageType.USER_INFO_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(Message.UPDATE_ADMIN_COMMAND_ERROR, e);
        }
        return PageType.HOME_PAGE.getAddress();
    }

    private void initializeAdminWithNewParameters(HttpServletRequest request, User admin) {
        admin.setName(request.getParameter(JspParameterType.NAME));
        admin.setSurname(request.getParameter(JspParameterType.SURNAME));
        admin.setPhone(request.getParameter(JspParameterType.PHONE));
    }
}
