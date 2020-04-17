package by.epam.agency.service;

import by.epam.agency.entity.City;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface CityService {
    void create(City city) throws ServiceException;

    void delete(int id) throws ServiceException;

    City findCityById(int id) throws ServiceException;

    List<City> getAllCities() throws ServiceException;
}
