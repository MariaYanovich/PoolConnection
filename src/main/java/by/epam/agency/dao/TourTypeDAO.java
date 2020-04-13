package by.epam.agency.dao;

import by.epam.agency.entity.TourType;
import by.epam.agency.exception.DAOException;

public interface TourTypeDAO extends DAO<TourType> {
    String findTourType(String tourType) throws DAOException;
}
