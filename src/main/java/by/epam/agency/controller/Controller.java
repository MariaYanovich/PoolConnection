package by.epam.agency.controller;

import by.epam.agency.command.Command;
import by.epam.agency.enums.JSPParameterType;
import by.epam.agency.exception.ConnectionPoolException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.getInstance().doCommand(request.getParameter(JSPParameterType.COMMAND.getValue()));
        String nextPage = command.execute(request, response);
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}
