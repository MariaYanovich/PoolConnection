package by.epam.agency.dao;

import by.epam.agency.entity.City;
import by.epam.agency.exception.DAOException;

public interface CityDAO extends DAO<City> {
    String findCity(String city) throws DAOException;
}
