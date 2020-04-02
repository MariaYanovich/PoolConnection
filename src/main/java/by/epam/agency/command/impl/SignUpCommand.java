package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JSPParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        try {
            User user = signUp(request);
            session.setAttribute(JSPParameterType.ROLE, user.getUserRole());
            session.setAttribute(JSPParameterType.USER, user);
            page = (String) session.getAttribute(JSPParameterType.FROM_PAGE);
        } catch (ServiceException e) {
            page = PageType.SIGN_UP_PAGE.getAddress();
        }
        if (page == null || page.isEmpty()) {
            return PageType.CLIENT_PAGE.getAddress();
        }
        return page;
    }

    private User signUp(HttpServletRequest request) throws ServiceException {
        UserService userService = ServiceFactory.getInstance().getUserService();
        String login = request.getParameter(JSPParameterType.LOGIN);
        String password = request.getParameter(JSPParameterType.PASSWORD);
        String name = request.getParameter(JSPParameterType.NAME);
        String surname = request.getParameter(JSPParameterType.SURNAME);
        String cash = request.getParameter(JSPParameterType.CASH);
        String phone = request.getParameter(JSPParameterType.PHONE);
        return userService.signUp(login, password, name, surname, cash, phone);
    }
}
