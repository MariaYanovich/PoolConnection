package by.epam.agency.filter;


import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    private static final String ENGLISH = "en";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String localeName = request.getParameter(JspParameterType.LANGUAGE);
        if (localeName == null) {
            localeName = (String) session.getAttribute(SessionAttribute.LOCALE);
            if (localeName == null) {
                localeName = ENGLISH;
            }
            session.setAttribute(SessionAttribute.LOCALE, localeName);
            filterChain.doFilter(request, response);
            return;
        } else {
            session.setAttribute(SessionAttribute.LOCALE, localeName);
        }
        request.getRequestDispatcher(PageType.HOME_PAGE.getAddress()).forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
