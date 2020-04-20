package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateClientCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UpdateClientCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User client = new User();
        try {
            initializeClient(request, client);
            ServiceFactory.getInstance().getUserService().updateClient(client);
            return PageType.USER_INFO_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }

    private void initializeClient(HttpServletRequest request, User client) {
        client.setId(Integer.parseInt(request.getSession().
                getAttribute(JspParameterType.USER_ID).toString()));
        client.setName(request.getParameter(JspParameterType.NAME));
        request.getSession().setAttribute(JspParameterType.NAME, client.getName());
        client.setSurname(request.getParameter(JspParameterType.SURNAME));
        request.getSession().setAttribute(JspParameterType.SURNAME, client.getSurname());
        client.setPhone(request.getParameter(JspParameterType.PHONE));
        request.getSession().setAttribute(JspParameterType.PHONE, client.getPhone());
        client.setCash(Float.parseFloat(request.getParameter(JspParameterType.CASH)));
        request.getSession().setAttribute(JspParameterType.CASH, client.getCash());
    }
}
