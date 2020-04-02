package by.epam.agency.dao.impl;

import by.epam.agency.constants.SQLStatement;
import by.epam.agency.dao.UserRoleDAO;
import by.epam.agency.entity.UserRole;
import by.epam.agency.enums.SQLColumn;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRoleDAOImpl implements UserRoleDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserRoleDAOImpl.class.getName());
    private static final int USER_ROLE_ID_QUERY_INDEX = 1;

    private UserRoleDAOImpl() {

    }

    public static UserRoleDAO getInstance() {
        return RoleDAOImplHolder.INSTANCE;
    }

    @Override
    public UserRole getById(int id) throws DAOException {
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
            throw new DAOException();
        }
        return userRole;
    }

    @Override
    public void create(UserRole item) throws DAOException {
        throw new DAOException();
    }

    @Override
    public void delete(UserRole item) throws DAOException {
        throw new DAOException();
    }

    @Override
    public void delete(int id) throws DAOException {
        throw new DAOException();
    }

    @Override
    public ArrayList<UserRole> getAll() throws DAOException {
        throw new DAOException();
    }

    @Override
    public void update(UserRole item) throws DAOException {
        throw new DAOException();
    }

    private static final class RoleDAOImplHolder {
        private static final UserRoleDAOImpl INSTANCE = new UserRoleDAOImpl();
    }
}
