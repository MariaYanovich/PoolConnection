package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Role;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        UserService userService = ServiceFactory.getInstance().getUserService();
        String login = request.getParameter(JspParameterType.LOGIN);
        String password = request.getParameter(JspParameterType.PASSWORD);
        try {
            User user = userService.signIn(login, password);
            if (user != null && !user.getRole().equals(Role.BLOCKED)) {
                setSessionAttributes(session, user);
                return PageType.HOME_PAGE.getAddress();
            }
        } catch (ServiceException e) {
            session.setAttribute(JspParameterType.ERROR, "User not found. Create your account, please.");
        }
        return PageType.REPEAT_SIGN_IN_PAGE.getAddress();
    }

    private void setSessionAttributes(HttpSession session, User user) {
        session.setAttribute(JspParameterType.LOGIN, user.getLogin());
        session.setAttribute(JspParameterType.PASSWORD, user.getPassword());
        session.setAttribute(JspParameterType.ID, user.getId());
        session.setAttribute(JspParameterType.NAME, user.getName());
        session.setAttribute(JspParameterType.SURNAME, user.getSurname());
        session.setAttribute(JspParameterType.DISCOUNT, user.getDiscount());
        session.setAttribute(JspParameterType.CASH, user.getCash());
        session.setAttribute(JspParameterType.PHONE, user.getPhone());
        session.setAttribute(JspParameterType.ROLE, user.getRole());
    }
}
