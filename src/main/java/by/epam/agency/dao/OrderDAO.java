package by.epam.agency.dao;

import by.epam.agency.entity.Order;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

import java.util.List;

public interface OrderDAO extends DAO<Order> {
    void updateUserDiscount(User user) throws DAOException;

    List<Order> findOrdersByUserId(int userId) throws DAOException;

    void updateOrdersStatus() throws DAOException;
}
