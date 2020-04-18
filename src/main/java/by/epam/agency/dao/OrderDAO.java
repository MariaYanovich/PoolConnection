package by.epam.agency.dao;

import by.epam.agency.entity.Order;
import by.epam.agency.exception.DAOException;

public interface OrderDAO extends DAO<Order> {

    void updateOrdersStatus() throws DAOException;
}
