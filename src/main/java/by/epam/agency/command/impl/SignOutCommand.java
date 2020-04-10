package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JSPParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        request.getSession().setAttribute(JSPParameterType.ROLE, Role.GUEST);
        request.getSession().setAttribute(JSPParameterType.PAGE, PageType.HOME_PAGE.getAddress());
        return PageType.HOME_PAGE.getAddress();
    }
}
