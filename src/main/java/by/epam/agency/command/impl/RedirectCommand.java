package by.epam.agency.command.impl;


import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JSPParameterType;
import by.epam.agency.command.constants.PageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(JSPParameterType.PAGE, PageType.valueOf(request.getParameter(JSPParameterType.ADDRESS)).getAddress());
        return PageType.valueOf(request.getParameter(JSPParameterType.ADDRESS)).getAddress();
    }
}
