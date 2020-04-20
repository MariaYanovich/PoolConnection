package by.epam.agency.service;

import by.epam.agency.entity.Transport;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface TransportService {
    Transport findTransportById(int transportId) throws ServiceException;

    List<Transport> getAllTransports() throws ServiceException;
}
