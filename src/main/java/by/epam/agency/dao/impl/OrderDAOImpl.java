package by.epam.agency.dao.impl;

import by.epam.agency.dao.OrderDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.entity.Order;
import by.epam.agency.entity.OrderStatus;
import by.epam.agency.entity.Tour;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrderDAOImpl.class.getName());

    private static final int CREATE_USER_ID_INDEX = 1;
    private static final int CREATE_TOUR_ID_INDEX = 2;
    private static final int CREATE_TOUR_NUMBER_INDEX = 3;
    private static final int CREATE_PRICE_INDEX = 4;

    private static final int USER_ID_INDEX = 1;
    private static final int ORDER_ID_INDEX = 1;
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
        Order order = new Order();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.FIND_ORDER_BY_ID)) {
            statement.setInt(ORDER_ID_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    initializeOrder(order, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return order;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        List<Order> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_ORDERS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    initializeOrder(order, resultSet);
                    listToReturn.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public List<Order> getOrdersByUserId(int id) throws DAOException {
        List<Order> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_ORDERS_BY_USER_ID)) {
            statement.setInt(USER_ID_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    initializeOrder(order, resultSet);
                    listToReturn.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public void updateOrdersStatus() throws DAOException {
        List<Order> orderList = getAll();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.SET_BOUGHT_ORDER)) {
            for (Order order : orderList) {
                if (order.getTour().getDepartureDate().before(Calendar.getInstance().getTime())) {
                    statement.setInt(ORDER_ID_INDEX, order.getOrderId());
                    order.setOrderStatus(OrderStatus.BOUGHT);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public void update(Order id) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    private void initializeCreateOrderStatement(PreparedStatement statement, Order order) throws SQLException {
        statement.setInt(CREATE_USER_ID_INDEX, order.getUser().getUserId());
        statement.setInt(CREATE_TOUR_ID_INDEX, order.getTour().getTourId());
        statement.setInt(CREATE_TOUR_NUMBER_INDEX, order.getNumber());
        statement.setDouble(CREATE_PRICE_INDEX, order.getPrice());
    }

    private void initializeOrder(Order order, ResultSet resultSet) throws SQLException {
        order.setOrderId(resultSet.getInt(SqlColumn.ORDER_ID.toString()));
        order.setUser(new User(resultSet.getInt(SqlColumn.USER_ID.toString()),
                resultSet.getString(SqlColumn.USER_LOGIN.toString())));
        order.setTour(new Tour(resultSet.getInt(SqlColumn.TOUR_ID.toString()),
                resultSet.getString(SqlColumn.TOUR_NAME.toString()),
                resultSet.getDate(SqlColumn.TOUR_DEPARTURE_DATE.toString())));
        order.setNumber(resultSet.getInt(SqlColumn.TOUR_NUMBER.toString()));
        order.setPrice(resultSet.getDouble(SqlColumn.PRICE.toString()));
        order.setOrderStatus(OrderStatus.valueOf(resultSet.getString(SqlColumn.ORDER_STATUS.toString()).toUpperCase()));
    }

    private static final class OrderDAOImplHolder {
        private static final OrderDAOImpl INSTANCE = new OrderDAOImpl();
    }
}
