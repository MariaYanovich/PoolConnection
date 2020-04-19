package by.epam.agency.dao;

import by.epam.agency.entity.Order;
import by.epam.agency.exception.DAOException;

import java.util.List;

public interface OrderDAO extends DAO<Order> {

    List<Order> getOrdersByUserId(int id) throws DAOException;

    void updateOrdersStatus() throws DAOException;
}
