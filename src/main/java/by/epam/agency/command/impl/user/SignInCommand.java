package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.Role;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        try {
            User user = ServiceFactory.getInstance().getUserService().
                    signIn(request.getParameter(JspParameterType.LOGIN),
                            request.getParameter(JspParameterType.PASSWORD));
            if (user != null && !user.getRole().equals(Role.BLOCKED)) {
                session.setAttribute(SessionAttribute.USER, user);
                session.setAttribute(SessionAttribute.ROLE, user.getRole());
                return PageType.HOME_PAGE.getAddress();
            }
        } catch (ServiceException e) {
            LOGGER.error(Message.SIGN_IN_COMMAND_ERROR, e);
        }
        return PageType.REPEAT_SIGN_IN_PAGE.getAddress();
    }
}
