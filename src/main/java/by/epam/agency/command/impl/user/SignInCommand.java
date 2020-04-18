package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.util.CommandUtil;
import by.epam.agency.entity.Role;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String login = request.getParameter(JspParameterType.LOGIN);
        String password = request.getParameter(JspParameterType.PASSWORD);
        try {
            User user = ServiceFactory.getInstance().getUserService().signIn(login, password);
            if (user != null && !user.getRole().equals(Role.BLOCKED)) {
                new CommandUtil().setSessionAttributesForUserAuthorize(session, user);
                return PageType.HOME_PAGE.getAddress();
            }
        } catch (ServiceException e) {
            session.setAttribute(JspParameterType.ERROR, "User not found. Create your account, please.");
        }
        return PageType.REPEAT_SIGN_IN_PAGE.getAddress();
    }
}
