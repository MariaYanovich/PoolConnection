package by.epam.agency.command.impl.redirect;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectToUpdateTourPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        new CommandUtil().setTourSessionAttribute(request);
        return PageType.UPDATE_TOUR_PAGE.getAddress();
    }
}
