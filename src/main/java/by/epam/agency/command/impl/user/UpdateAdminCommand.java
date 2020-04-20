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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User admin = new User();
        try {
            initializeAdmin(request, admin);
            ServiceFactory.getInstance().getUserService().updateAdmin(admin);
            return PageType.USER_INFO_PAGE.getAddress();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.HOME_PAGE.getAddress();
    }

    private void initializeAdmin(HttpServletRequest request, User admin) {
        admin.setId(Integer.parseInt(request.getSession().
                getAttribute(JspParameterType.USER_ID).toString()));
        admin.setName(request.getParameter(JspParameterType.NAME));
        request.getSession().setAttribute(JspParameterType.NAME, admin.getName());
        admin.setSurname(request.getParameter(JspParameterType.SURNAME));
        request.getSession().setAttribute(JspParameterType.SURNAME, admin.getSurname());
        admin.setPhone(request.getParameter(JspParameterType.PHONE));
        request.getSession().setAttribute(JspParameterType.PHONE, admin.getPhone());
        request.getSession().setAttribute(JspParameterType.CASH, admin.getCash());
    }
}
