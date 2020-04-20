package by.epam.agency.filter;

import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String whereTo = request.getParameter(JspParameterType.ADDRESS);
        if (whereTo != null) {
            request.getRequestDispatcher(PageType.valueOf(whereTo).getAddress()).forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
