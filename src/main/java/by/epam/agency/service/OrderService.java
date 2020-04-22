package by.epam.agency.service;

import by.epam.agency.entity.Order;
import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface OrderService {
    void createOrder(Order order) throws ServiceException;

    void deleteOrder(int orderId) throws ServiceException;

    Order findOrderById(int orderId) throws ServiceException;

    List<Order> getAllOrders() throws ServiceException;

    List<Order> findOrdersByUserId(int userId) throws ServiceException;

    void updateOrdersStatus() throws ServiceException;

    void updateUserDiscount(User user) throws ServiceException;
}
