package by.epam.agency.service;

import by.epam.agency.entity.TourType;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface TourTypeService {
    void createTourType(TourType tourType) throws ServiceException;

    void deleteTourTypeById(int tourTypeId) throws ServiceException;

    TourType findTourTypeById(int tourTypeId) throws ServiceException;

    List<TourType> getAllTourTypes() throws ServiceException;
}
