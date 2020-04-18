package by.epam.agency.controller;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.exception.ConnectionPoolException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(urlPatterns = {""})
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());

    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.INSTANCE.initConnectionPool();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceFactory.getInstance().getTourService().updateArchivedTours();
        ServiceFactory.getInstance().getOrderService().updateOrdersStatus();
        Command command = CommandFactory.getInstance().getCommand(request.getParameter(JspParameterType.COMMAND));
        String nextPage = command.execute(request, response);
        request.getSession().setAttribute(JspParameterType.PAGE, nextPage);
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

    @Override
    public void destroy() {

        try {
            ConnectionPool.INSTANCE.destroyPool();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        super.destroy();
        LOGGER.debug("Servlet is destroied");
    }
}
