package by.epam.agency.dao;

import by.epam.agency.entity.City;
import by.epam.agency.entity.Tour;
import by.epam.agency.exception.DAOException;

import java.util.Date;
import java.util.List;

public interface TourDAO extends DAO<Tour> {

    void unHotTour(int tourId) throws DAOException;

    void setHotTour(int tourId) throws DAOException;

    List<Tour> getHotTours() throws DAOException;

    List<Tour> searchTourByParameters(City city, Date departureDate, int days, double cost) throws DAOException;

    List<Tour> getToursByCityId(int cityId) throws DAOException;

    List<Tour> getToursByTourTypeId(int tourTypeId) throws DAOException;

    void buyTour(Tour tour, int amount) throws DAOException;

    void returnTour(Tour tour, int amount) throws DAOException;

    void updateArchiveTours() throws DAOException;
}
