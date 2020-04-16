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
    public void addTour(Tour tour) throws ServiceException {
        try {
            tourDAO.create(tour);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
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

    @Override
    public List<Tour> getToursByCityId(int id) throws ServiceException {
        try {
            return tourDAO.getToursByCityId(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> getToursByTourTypeId(int id) throws ServiceException {
        try {
            return tourDAO.getToursByTourTypeId(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void unHotTour(int id) throws ServiceException {
        try {
            tourDAO.unHotTour(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTour(int id) throws ServiceException {
        try {
            tourDAO.delete(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void setHotTour(int id) throws ServiceException {
        try {
            tourDAO.setHotTour(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    private static final class TourServiceImplHolder {
        private static final TourServiceImpl INSTANCE = new TourServiceImpl();
    }
}
