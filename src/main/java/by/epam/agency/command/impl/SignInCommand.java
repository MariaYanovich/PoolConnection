package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JSPParameterType;
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
        String page = null;
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();
        String login = request.getParameter(JSPParameterType.LOGIN);
        String password = request.getParameter(JSPParameterType.PASSWORD);
        try {
            User user = userService.signIn(login, password);
            if (user != null) {
                request.setAttribute(JSPParameterType.USER, user);
                setSessionAttributes(session, user);
                if (user.getRole().equals(Role.CLIENT) ||
                        user.getRole().equals(Role.ADMIN)) {
                    request.getSession().setAttribute(JSPParameterType.PAGE, PageType.HOME_PAGE.getAddress());
                    page = PageType.HOME_PAGE.getAddress();
                }
            }
        } catch (ServiceException e) {
            session.setAttribute(JSPParameterType.ERROR, "User not found. Create your account, please.");
            request.getSession().setAttribute(JSPParameterType.PAGE, PageType.REPEAT_SIGN_IN_PAGE.getAddress());
            page = PageType.REPEAT_SIGN_IN_PAGE.getAddress();
        }
        return page;
    }

    private void setSessionAttributes(HttpSession session, User user) {
        session.setAttribute(JSPParameterType.ID, user.getId());
        session.setAttribute(JSPParameterType.NAME, user.getName());
        session.setAttribute(JSPParameterType.SURNAME, user.getSurname());
        session.setAttribute(JSPParameterType.DISCOUNT, user.getDiscount());
        session.setAttribute(JSPParameterType.CASH, user.getCash());
        session.setAttribute(JSPParameterType.PHONE, user.getPhone());
        session.setAttribute(JSPParameterType.ROLE, user.getRole());
    }
}
