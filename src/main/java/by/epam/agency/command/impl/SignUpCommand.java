package by.epam.agency.command.impl;

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

public class SignUpCommand implements Command {

    public static User signUp(HttpServletRequest request) throws ServiceException {
        String login = request.getParameter(JspParameterType.LOGIN);
        String password = request.getParameter(JspParameterType.PASSWORD);
        String name = request.getParameter(JspParameterType.NAME);
        String surname = request.getParameter(JspParameterType.SURNAME);
        String cash = request.getParameter(JspParameterType.CASH);
        String phone = request.getParameter(JspParameterType.PHONE);
        return ServiceFactory.getInstance().getUserService().signUp(login, password, name, surname, cash, phone);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession(true);
        try {
            SignInCommand.setSessionAttributes(session, signUp(request));
            session.setAttribute(JspParameterType.ROLE, Role.CLIENT);
            page = PageType.HOME_PAGE.getAddress();
        } catch (ServiceException e) {
            page = PageType.SIGN_UP_PAGE.getAddress();
        }
        return page;
    }
}
