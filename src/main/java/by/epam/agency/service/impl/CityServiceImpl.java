package by.epam.agency.service.impl;

import by.epam.agency.dao.CityDAO;
import by.epam.agency.entity.City;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.exception.ValidatorException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.CityService;
import by.epam.agency.validator.ProperNameValidator;
import by.epam.agency.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LogManager.getLogger(CityServiceImpl.class.getName());

    private CityDAO cityDAO = DAOFactory.getInstance().getCityDAO();

    private CityServiceImpl() {

    }

    public static CityService getInstance() {
        return CityServiceImpl.CityServiceImplHolder.INSTANCE;
    }

    @Override
    public void create(City city) throws ServiceException {
        Validator validator = new ProperNameValidator(city.getCity());
        try {
            validator.validate();
            if (checkCityExistence(city.getCity())) {
                cityDAO.create(city);
            }
        } catch (DAOException | ValidatorException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int cityId) throws ServiceException {
        try {
            cityDAO.delete(cityId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public City findCityById(int cityId) throws ServiceException {
        try {
            return cityDAO.findById(cityId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<City> getAllCities() throws ServiceException {
        try {
            return cityDAO.getAll();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    private boolean checkCityExistence(String city) throws DAOException {
        return cityDAO.findCity(city) == null;
    }

    private static final class CityServiceImplHolder {
        private static final CityServiceImpl INSTANCE = new CityServiceImpl();
    }
}
