package by.epam.agency.filter;


import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(RoleFilter.class.getName());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        Object userRoleObject = httpSession.getAttribute(JspParameterType.ROLE);
        if (userRoleObject == null) {
            httpSession.setAttribute(JspParameterType.ROLE, Role.GUEST);
            LOGGER.debug("Set guest role to user");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
