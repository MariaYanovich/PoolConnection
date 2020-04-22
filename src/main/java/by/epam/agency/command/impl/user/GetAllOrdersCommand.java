package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.Order;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetAllOrdersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GetAllOrdersCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Order> listResults = new ArrayList<>();
        try {
            listResults = ServiceFactory.getInstance().getOrderService().getAllOrders();
        } catch (ServiceException e) {
            LOGGER.error(Message.GET_ALL_ORDERS_COMMAND_ERROR, e);
        }
        request.setAttribute(JspParameterType.ORDERS, listResults);
        return PageType.ORDERS_LIST_PAGE.getAddress();
    }
}
