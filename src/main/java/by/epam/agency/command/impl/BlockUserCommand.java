package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.CommandType;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.CommandFactory;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(JspParameterType.ID);
        System.out.println(id);
        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            userService.blockUser(Integer.parseInt(id));
            Command getUsersList = CommandFactory.getInstance().getCommand(CommandType.GET_USERS_LIST.toString());
            return getUsersList.execute(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return PageType.HOME_PAGE.getAddress();
    }
}
