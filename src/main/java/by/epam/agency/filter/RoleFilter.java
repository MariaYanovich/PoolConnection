package by.epam.agency.filter;


import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        Object userRoleObject = httpSession.getAttribute(SessionAttribute.ROLE);
        if (userRoleObject == null) {
            httpSession.setAttribute(SessionAttribute.ROLE, Role.GUEST);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
