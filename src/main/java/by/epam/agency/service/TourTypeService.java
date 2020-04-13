package by.epam.agency.service;

import by.epam.agency.entity.TourType;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface TourTypeService {
    void create(TourType tourType) throws ServiceException;

    void delete(int id) throws ServiceException;

    TourType findById(int id) throws ServiceException;

    List<TourType> getAll() throws ServiceException;
}
