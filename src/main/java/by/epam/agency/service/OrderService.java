package by.epam.agency.service;

import by.epam.agency.entity.Order;
import by.epam.agency.exception.ServiceException;

public interface OrderService {
    void createOrder(Order order) throws ServiceException;

    void deleteOrder(Order order) throws ServiceException;
}
