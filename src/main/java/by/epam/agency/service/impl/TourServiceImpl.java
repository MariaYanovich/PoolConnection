package by.epam.agency.service.impl;

import by.epam.agency.dao.TourDAO;
import by.epam.agency.entity.City;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.exception.ValidatorException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.TourService;
import by.epam.agency.validator.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
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
        Validator validator = createAddTourParametersValidator(tour);
        try {
            validator.validate();
            tourDAO.create(tour);
        } catch (DAOException | ValidatorException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateTour(Tour tour) throws ServiceException {
        Validator validator = createUpdateParametersValidator(tour);
        try {
            validator.validate();
            tourDAO.update(tour);
        } catch (DAOException | ValidatorException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Tour findTour(int id) throws ServiceException {
        try {
            return tourDAO.findById(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> searchToursByParameters(City city, Date departureDate, int days, float cost) throws ServiceException {
        try {
            return tourDAO.searchTourByParameters(city, departureDate, days, cost);
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

    private Validator createAddTourParametersValidator(Tour tour) {
        Validator nameValidator = new ProperNameValidator(tour.getName());
        Validator costValidator = new MoneyValidator(tour.getCost());
        Validator daysValidator = new PositiveIntValidator(tour.getDays());
        Validator placesValidator = new PositiveIntValidator(tour.getPlaces());
        Validator dateValidator = new TourDateValidator(tour.getDepartureDate());
        nameValidator.setNext(costValidator);
        costValidator.setNext(daysValidator);
        daysValidator.setNext(placesValidator);
        placesValidator.setNext(dateValidator);
        return nameValidator;
    }

    private Validator createUpdateParametersValidator(Tour tour) {
        Validator costValidator = new MoneyValidator(tour.getCost());
        Validator daysValidator = new PositiveIntValidator(tour.getDays());
        Validator placesValidator = new PositiveIntValidator(tour.getPlaces());
        Validator dateValidator = new TourDateValidator(tour.getDepartureDate());
        costValidator.setNext(daysValidator);
        daysValidator.setNext(placesValidator);
        placesValidator.setNext(dateValidator);
        return costValidator;
    }

    private static final class TourServiceImplHolder {
        private static final TourServiceImpl INSTANCE = new TourServiceImpl();
    }
}
