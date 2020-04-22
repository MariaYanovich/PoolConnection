package by.epam.agency.controller;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.exception.ConnectionPoolException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.util.Message;
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
    public void init() {
        try {
            ConnectionPool.INSTANCE.initConnectionPool();
        } catch (ConnectionPoolException e) {
            LOGGER.error(Message.SERVLET_INIT_ERROR, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (ServiceException e) {
            LOGGER.error(Message.SERVLET_DO_GET_ERROR, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (ServiceException e) {
            LOGGER.error(Message.SERVLET_DO_POST_ERROR, e);
        }
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        ServiceFactory.getInstance().getTourService().updateArchivedTours();
        ServiceFactory.getInstance().getOrderService().updateOrdersStatus();
        Command command = CommandFactory.getInstance().getCommand(request.getParameter(JspParameterType.COMMAND));
        String nextPage = command.execute(request, response);
        request.getSession().setAttribute(SessionAttribute.PAGE, nextPage);
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.INSTANCE.destroyPool();
        } catch (InterruptedException e) {
            LOGGER.error(Message.SERVLET_DESTROY_ERROR, e);
        }
        super.destroy();
        LOGGER.debug(Message.SERVLET_DESTROY);
    }
}
