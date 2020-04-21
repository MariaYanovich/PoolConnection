package by.epam.agency.command.impl.tour;

import by.epam.agency.command.Command;
import by.epam.agency.command.constants.JspParameterType;
import by.epam.agency.command.constants.PageType;
import by.epam.agency.command.constants.SessionAttribute;
import by.epam.agency.entity.TourType;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTourTypeCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger(AddTourTypeCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TourType tourType = new TourType();
        tourType.setType(request.getParameter(JspParameterType.TOUR_TYPE));
        try {
            ServiceFactory.getInstance().getTourTypeService().create(tourType);
            request.getSession().setAttribute(SessionAttribute.TOUR_TYPES,
                    ServiceFactory.getInstance().getTourTypeService().getAllTourTypes());
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PageType.SERVICE_PAGE.getAddress();
    }
}
