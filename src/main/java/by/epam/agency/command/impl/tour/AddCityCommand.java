package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.City;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCityCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger(AddCityCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        City city = new City();
        city.setCity(request.getParameter(JspParameterType.CITY));
        try {
            ServiceFactory.getInstance().getCityService().createCity(city);
            request.getSession().setAttribute(SessionAttribute.CITIES,
                    ServiceFactory.getInstance().getCityService().getAllCities());
        } catch (ServiceException e) {
            LOGGER.error(Message.ADD_CITY_COMMAND_ERROR, e);
        }
        return PageType.SERVICE_PAGE.getAddress();
    }
}
