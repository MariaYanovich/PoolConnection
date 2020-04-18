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

public class UpdateAdminCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UpdateAdminCommand.class.getName());

    public static void updateAdmin(HttpServletRequest request) throws ServiceException {
        User user = new User();
        user.setId(Integer.parseInt(request.getSession().getAttribute(JspParameterType.USER_ID).toString()));
        user.setName(request.getParameter(JspParameterType.NAME));
        request.getSession().setAttribute(JspParameterType.NAME, user.getName());
        user.setSurname(request.getParameter(JspParameterType.SURNAME));
        request.getSession().setAttribute(JspParameterType.SURNAME, user.getSurname());
        user.setPhone(request.getParameter(JspParameterType.PHONE));
        request.getSession().setAttribute(JspParameterType.PHONE, user.getPhone());
        request.getSession().setAttribute(JspParameterType.CASH, user.getCash());
        ServiceFactory.getInstance().getUserService().updateAdmin(user);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            updateAdmin(request);
            return PageType.USER_INFO_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
