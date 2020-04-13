package by.epam.agency.service.impl;

import by.epam.agency.dao.TourDAO;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.TourService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TourServiceImpl implements TourService {
    private static final Logger LOGGER = LogManager.getLogger(TourServiceImpl.class.getName());

    private TourDAO tourDAO = DAOFactory.getInstance().getTourDAO();

    private TourServiceImpl() {

    }

    public static TourService getInstance() {
        return TourServiceImplHolder.INSTANCE;
    }

    @Override
    public List<Tour> getAllTours() throws ServiceException {
        try {
            return tourDAO.getAll();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> getHotTours() throws ServiceException {
        try {
            return tourDAO.getHotTours();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    private static final class TourServiceImplHolder {
        private static final TourServiceImpl INSTANCE = new TourServiceImpl();
    }
}
