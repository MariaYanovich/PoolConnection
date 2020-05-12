package by.epam.agency.command.impl.user;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.command.impl.HomeCommand;
import by.epam.agency.entity.Role;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignUpCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession(true);
        try {
            session.setAttribute(SessionAttribute.USER, createClient(request));
            session.setAttribute(SessionAttribute.ROLE, Role.CLIENT);
            page = new HomeCommand().execute(request, response);
        } catch (ServiceException e) {
            page = PageType.SIGN_UP_PAGE.getAddress();
            LOGGER.error(Message.SIGN_UP_COMMAND_ERROR, e);
        }
        return page;
    }

    private User createClient(HttpServletRequest request) throws ServiceException {
        String login = request.getParameter(JspParameterType.LOGIN);
        String password = request.getParameter(JspParameterType.PASSWORD);
        String name = request.getParameter(JspParameterType.NAME);
        String surname = request.getParameter(JspParameterType.SURNAME);
        String cash = request.getParameter(JspParameterType.CASH);
        String phone = request.getParameter(JspParameterType.PHONE);
        return ServiceFactory.getInstance().getUserService().
                signUp(login, password, name, surname, cash, phone);
    }
}
