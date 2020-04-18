package by.epam.agency.command.impl.redirect;


import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageType.valueOf(request.getParameter(JspParameterType.ADDRESS)).getAddress();
    }
}
