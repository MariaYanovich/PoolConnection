package by.epam.agency.dao.impl;

import by.epam.agency.constants.SQLStatement;
import by.epam.agency.dao.RoleDAO;
import by.epam.agency.entity.Role;
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

public class RoleDAOImpl implements RoleDAO {

    private static final Logger LOGGER = LogManager.getLogger(RoleDAOImpl.class.getName());
    private static final int USER_ROLE_ID_QUERY_INDEX = 1;

    private RoleDAOImpl() {

    }

    public static RoleDAO getInstance() {
        return RoleDAOImplHolder.INSTANCE;
    }

    @Override
    public Role getById(int id) throws DAOException {
        Role role = Role.GUEST;
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ROLE_BY_ID)) {
            statement.setInt(USER_ROLE_ID_QUERY_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    role = Role.valueOf(resultSet.getString(SQLColumn.USER_ROLE.toString()).toUpperCase());
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        return role;
    }

    @Override
    public void create(Role item) throws DAOException {
        throw new DAOException();
    }

    @Override
    public void delete(Role item) throws DAOException {
        throw new DAOException();
    }

    @Override
    public void delete(int id) throws DAOException {
        throw new DAOException();
    }

    @Override
    public ArrayList<Role> getAll() throws DAOException {
        throw new DAOException();
    }

    @Override
    public void update(Role item) throws DAOException {
        throw new DAOException();
    }

    private static final class RoleDAOImplHolder {
        private static final RoleDAOImpl INSTANCE = new RoleDAOImpl();
    }
}
