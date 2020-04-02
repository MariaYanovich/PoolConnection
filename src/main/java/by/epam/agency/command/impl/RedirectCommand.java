package by.epam.agency.command.impl;


import by.epam.agency.command.Command;
import by.epam.agency.constants.JSPParameterType;
import by.epam.agency.enums.PageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(RedirectCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pageTo = request.getParameter(JSPParameterType.TO_PAGE_REQUEST);
        String pageFrom = request.getParameter(JSPParameterType.FROM_PAGE_REQUEST);
        setAttribute(request, pageTo, pageFrom);
        PageType page;
        if (pageTo == null || pageTo.isEmpty()) {
            page = PageType.HOME_PAGE;
        } else {
            page = PageType.valueOf(pageTo.toUpperCase());
        }
        return page.getAddress();
    }

    private void setAttribute(HttpServletRequest request, String pageTo, String pageFrom) {
        HttpSession session = request.getSession();
        session.setAttribute(JSPParameterType.TO_PAGE, pageTo);
        if (pageFrom != null && !pageFrom.isEmpty()) {
            session.setAttribute(JSPParameterType.FROM_PAGE, PageType.valueOf(pageFrom));
            LOGGER.debug(PageType.valueOf(pageFrom));
        }
    }
}
