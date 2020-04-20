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

import java.sql.Date;
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
    public Tour findTourById(int tourId) throws ServiceException {
        try {
            return tourDAO.findById(tourId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> searchToursByParameters(City city, Date departureDate, int days, double cost) throws ServiceException {
        Validator validator = createSearchParametersValidator(departureDate, days, cost);
        try {
            validator.validate();
            return tourDAO.searchTourByParameters(city, departureDate, days, cost);
        } catch (DAOException | ValidatorException e) {
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
    public List<Tour> getToursByCityId(int cityId) throws ServiceException {
        try {
            return tourDAO.getToursByCityId(cityId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> getToursByTourTypeId(int tourTypeId) throws ServiceException {
        try {
            return tourDAO.getToursByTourTypeId(tourTypeId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void unHotTour(int tourId) throws ServiceException {
        try {
            tourDAO.unHotTour(tourId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTour(int tourId) throws ServiceException {
        try {
            tourDAO.delete(tourId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void setHotTour(int tourId) throws ServiceException {
        try {
            tourDAO.setHotTour(tourId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void buyTour(Tour tour, int amount) throws ServiceException {
        try {
            tourDAO.buyTour(tour, amount);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void returnTour(Tour tour, int amount) throws ServiceException {
        try {
            tourDAO.returnTour(tour, amount);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateArchivedTours() throws ServiceException {
        try {
            tourDAO.updateArchiveTours();
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

    private Validator createSearchParametersValidator(Date departureDate, int days, double cost) {
        Validator costValidator = new MoneyValidator(cost);
        Validator daysValidator = new PositiveIntValidator(days);
        Validator dateValidator = new TourDateValidator(departureDate);
        costValidator.setNext(daysValidator);
        daysValidator.setNext(dateValidator);
        return costValidator;
    }

    private static final class TourServiceImplHolder {
        private static final TourServiceImpl INSTANCE = new TourServiceImpl();
    }
}
