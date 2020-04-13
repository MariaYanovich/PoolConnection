package by.epam.agency.dao.impl;

import by.epam.agency.dao.CityDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.entity.City;
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

public class CityDAOImpl implements CityDAO {
    private static final Logger LOGGER = LogManager.getLogger(CityDAOImpl.class.getName());

    private static final int CITY_INDEX = 1;
    private static final int CITY_ID_INDEX = 1;

    private CityDAOImpl() {

    }

    public static CityDAO getInstance() {
        return CityDAOImpl.CityDAOImplHolder.INSTANCE;
    }

    @Override
    public void create(City city) throws DAOException {
        try (ProxyConnection connection =
                     new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement =
                     connection.prepareStatement(SQLStatement.CREATE_CITY)) {
            statement.setString(CITY_INDEX, city.getCity());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SQLStatement.DELETE_CITY)) {
                statement.setInt(CITY_ID_INDEX, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public City findById(int id) throws DAOException {
        City city = new City();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_CITY_BY_ID)) {
            statement.setInt(CITY_ID_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    initializeCity(city, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return city;
    }

    @Override
    public List<City> getAll() throws DAOException {
        List<City> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_CITIES)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City();
                    initializeCity(city, resultSet);
                    listToReturn.add(city);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public String findCity(String city) throws DAOException {
        String cityToReturn = null;
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.CHECK_CITY)) {
            statement.setString(CITY_INDEX, city);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cityToReturn = resultSet.getString(SqlColumn.CITY.toString());
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return cityToReturn;
    }

    private void initializeCity(City city, ResultSet resultSet) throws SQLException {
        city.setCityId(resultSet.getInt(SqlColumn.CITY_ID.toString()));
        city.setCity(resultSet.getString(SqlColumn.CITY.toString()));
    }

    @Override
    public void update(City id) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void delete(City item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    private static final class CityDAOImplHolder {
        private static final CityDAOImpl INSTANCE = new CityDAOImpl();
    }
}
