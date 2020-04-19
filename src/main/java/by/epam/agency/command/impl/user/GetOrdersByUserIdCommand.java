package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Order;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetOrdersByUserIdCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetOrdersByUserIdCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(JspParameterType.USER_ID);
        List<Order> listResults = new ArrayList<>();
        try {
            listResults = ServiceFactory.getInstance().getOrderService().getOrdersByUserId(Integer.parseInt(id));
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        request.setAttribute(JspParameterType.ORDERS, listResults);
        return PageType.ORDERS_LIST_PAGE.getAddress();
    }
}
