package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
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
        try {
            User user = ServiceFactory.getInstance().getUserService().
                    signIn(request.getParameter(JspParameterType.LOGIN),
                            request.getParameter(JspParameterType.PASSWORD));
            if (user != null && !user.getRole().equals(Role.BLOCKED)) {
                session.setAttribute(JspParameterType.USER, user);
                session.setAttribute(JspParameterType.ROLE, user.getRole());
                return PageType.HOME_PAGE.getAddress();
            }
        } catch (ServiceException e) {
            session.setAttribute(JspParameterType.ERROR, "User not found. Create new account, please.");
        }
        return PageType.REPEAT_SIGN_IN_PAGE.getAddress();
    }
}
