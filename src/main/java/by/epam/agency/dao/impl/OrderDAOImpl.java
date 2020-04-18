package by.epam.agency.dao.impl;

import by.epam.agency.dao.OrderDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.entity.Order;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrderDAOImpl.class.getName());

    private static final int CREATE_USER_ID_INDEX = 1;
    private static final int CREATE_TOUR_ID_INDEX = 2;
    private static final int CREATE_TOUR_NUMBER_INDEX = 3;
    private static final int CREATE_PRICE_INDEX = 4;

    private static final int DELETE_ORDER_ID_INDEX = 1;

    private OrderDAOImpl() {

    }

    public static OrderDAO getInstance() {
        return OrderDAOImplHolder.INSTANCE;
    }

    @Override
    public void create(Order order) throws DAOException {
        try (ProxyConnection connection =
                     new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement =
                     connection.prepareStatement(SQLStatement.CREATE_ORDER)) {
            initializeCreateOrderStatement(statement, order);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Order order) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SQLStatement.DELETE_ORDER)) {
                statement.setInt(DELETE_ORDER_ID_INDEX, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public Order findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        return null;
    }

    @Override
    public void update(Order id) throws DAOException {

    }

    private void initializeCreateOrderStatement(PreparedStatement statement, Order order) throws SQLException {
        statement.setInt(CREATE_USER_ID_INDEX, order.getUser().getId());
        statement.setInt(CREATE_TOUR_ID_INDEX, order.getTour().getTourId());
        statement.setInt(CREATE_TOUR_NUMBER_INDEX, order.getNumber());
        statement.setDouble(CREATE_PRICE_INDEX, order.getPrice());
    }


    private static final class OrderDAOImplHolder {
        private static final OrderDAOImpl INSTANCE = new OrderDAOImpl();
    }
}
