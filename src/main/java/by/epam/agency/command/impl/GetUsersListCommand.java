package by.epam.agency.command.impl;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.dao.impl.UserDAOImpl;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUsersListCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> listResults = null;
        try {
            listResults = UserDAOImpl.getInstance().getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(JspParameterType.USERS, listResults);
        return PageType.USERS_LIST_PAGE.getAddress();
    }
}
