package by.epam.agency.service;

import by.epam.agency.entity.Tour;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours() throws ServiceException;

    List<Tour> getHotTours() throws ServiceException;
}