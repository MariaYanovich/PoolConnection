package by.epam.agency.service;

import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface TourService {

    void addTour(Tour tour) throws ServiceException;

    List<Tour> getAllTours() throws ServiceException;

    List<Tour> getHotTours() throws ServiceException;

    List<Tour> getToursByCityId(int id) throws ServiceException;

    List<Tour> getToursByTourTypeId(int id) throws ServiceException;

    void unHotTour(int id) throws ServiceException;

    void deleteTour(int id) throws ServiceException;

    void setHotTour(int id) throws ServiceException;

    void updateTour(Tour tour) throws ServiceException;

    Tour findTour(int id) throws ServiceException;
}
