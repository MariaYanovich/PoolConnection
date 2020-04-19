package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.entity.City;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCityCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger(AddCityCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cityStr = request.getParameter(JspParameterType.CITY);
        City city = new City();
        city.setCity(cityStr);
        try {
            ServiceFactory.getInstance().getCityService().create(city);
            request.getSession().setAttribute(JspParameterType.CITIES,
                    ServiceFactory.getInstance().getCityService().getAllCities());
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.SERVICE_PAGE.getAddress();
    }
}
