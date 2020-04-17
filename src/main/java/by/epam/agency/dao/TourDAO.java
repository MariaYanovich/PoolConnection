package by.epam.agency.dao;

import by.epam.agency.entity.City;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.DAOException;

import java.util.Date;
import java.util.List;

public interface TourDAO extends DAO<Tour> {

    void unHotTour(int id) throws DAOException;

    void setHotTour(int id) throws DAOException;

    List<Tour> getHotTours() throws DAOException;

    List<Tour> searchTourByParameters(City city, Date departureDate, int days, float cost) throws DAOException;

    List<Tour> getToursByCityId(int id) throws DAOException;

    List<Tour> getToursByTourTypeId(int id) throws DAOException;
}
