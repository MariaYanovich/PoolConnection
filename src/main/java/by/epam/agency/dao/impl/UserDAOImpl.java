package by.epam.agency.dao.impl;


import by.epam.agency.dao.UserDAO;
import by.epam.agency.dao.constants.SQLColumn;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.entity.Discount;
import by.epam.agency.entity.User;
import by.epam.agency.entity.UserRole;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class.getName());

    private static final int USER_ID_INDEX = 1;
    private static final int USER_ROLE_ID_QUERY_INDEX = 1;
    private static final int USER_LOGIN_INDEX = 1;
    private static final int USER_PASSWORD_INDEX = 2;

    private static final int CREATE_USER_LOGIN_INDEX = 1;
    private static final int CREATE_USER_PASSWORD_INDEX = 2;
    private static final int CREATE_USER_NAME_INDEX = 3;
    private static final int CREATE_USER_SURNAME_INDEX = 4;
    private static final int CREATE_USER_CASH_INDEX = 5;
    private static final int CREATE_USER_PHONE_INDEX = 6;

    private UserDAOImpl() {

    }

    public static UserDAO getInstance() {
        return UserDAOImplHolder.INSTANCE;
    }

    @Override
    public User findById(int id) throws DAOException {
        User user = new User();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_USER_BY_ID)) {
            statement.setInt(USER_ID_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    createUserForReturn(user, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return user;
    }

    @Override
    public String findLogin(String userLogin) throws DAOException {
        String login = null;
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.CHECK_LOGIN)) {
            statement.setString(USER_LOGIN_INDEX, userLogin);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    login = resultSet.getString(SQLColumn.USER_LOGIN.toString());
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }

        return login;
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        User user = new User();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(USER_LOGIN_INDEX, login);
            statement.setString(USER_PASSWORD_INDEX, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    createUserForReturn(user, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return user;
    }

    @Override
    public void create(User user) throws DAOException {
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.CREATE_USER)) {
            statement.setString(CREATE_USER_LOGIN_INDEX, user.getLogin());
            statement.setString(CREATE_USER_PASSWORD_INDEX, String.valueOf(user.getPassword()));
            statement.setString(CREATE_USER_NAME_INDEX, user.getName());
            statement.setString(CREATE_USER_SURNAME_INDEX, user.getSurname());
            statement.setFloat(CREATE_USER_CASH_INDEX, user.getCash());
            statement.setString(CREATE_USER_PHONE_INDEX, user.getPhone());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }


    @Override
    public void delete(User item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void delete(int id) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_USERS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    createUserForReturn(user, resultSet);
                    listToReturn.add(user);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public void update(User item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    private void createUserForReturn(User user, ResultSet resultSet) throws SQLException, DAOException {
        user.setId(resultSet.getInt(SQLColumn.USER_ID.toString()));
        user.setLogin(resultSet.getString(SQLColumn.USER_LOGIN.toString()));
        user.setPassword(resultSet.getString(SQLColumn.USER_PASSWORD.toString()).toCharArray());
        user.setName(resultSet.getString(SQLColumn.USER_NAME.toString()));
        user.setSurname(resultSet.getString(SQLColumn.USER_SURNAME.toString()));
        Discount discount = new Discount();
        discount.setId(resultSet.getInt(SQLColumn.USER_DISCOUNT_ID.toString()));
        user.setDiscount(discount);
        user.setCash(resultSet.getFloat(SQLColumn.USER_CASH.toString()));
        user.setPhone(resultSet.getString(SQLColumn.USER_PHONE.toString()));
        UserRole userRole = getUserRoleById(resultSet.getInt(SQLColumn.USER_ROLE_ID.toString()));
        user.setUserRole(userRole);
    }

    public UserRole getUserRoleById(int id) throws DAOException {
        UserRole userRole = UserRole.GUEST;
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_USER_ROLE_BY_ID)) {
            statement.setInt(USER_ROLE_ID_QUERY_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    userRole = UserRole.valueOf(resultSet.getString(SQLColumn.USER_ROLE.toString()).toUpperCase());
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return userRole;
    }

    private static final class UserDAOImplHolder {
        private static final UserDAOImpl INSTANCE = new UserDAOImpl();
    }
}
