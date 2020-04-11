package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAdminCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        try {
            createAdmin(request);
            page = PageType.HOME_PAGE.getAddress();
        } catch (ServiceException e) {
            page = PageType.CREATE_ADMIN_PAGE.getAddress();
        }
        return page;
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
