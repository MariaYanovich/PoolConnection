package by.epam.agency.dao.impl;

import by.epam.agency.dao.TourDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.entity.*;
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

public class TourDAOImpl implements TourDAO {

    private static final Logger LOGGER = LogManager.getLogger(TourDAOImpl.class.getName());

    private static final int CITY_ID_QUERY_INDEX = 1;

    private TourDAOImpl() {

    }

    public static TourDAO getInstance() {
        return TourDAOImplHolder.INSTANCE;
    }

    @Override
    public void create(Tour item) throws DAOException {

    }

    @Override
    public void delete(Tour item) throws DAOException {

    }

    @Override
    public void delete(int id) throws DAOException {

    }

    @Override
    public Tour findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Tour> getAll() throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_TOURS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tour tour = new Tour();
                    createTourToReturn(tour, resultSet);
                    listToReturn.add(tour);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public void update(Tour item) throws DAOException {

    }

    private void createTourToReturn(Tour tour, ResultSet resultSet) throws SQLException, DAOException {
        tour.setTourId(resultSet.getInt(SqlColumn.TOUR_ID.toString()));
        tour.setName(resultSet.getString(SqlColumn.TOUR_NAME.toString()));
        tour.setCost(resultSet.getFloat(SqlColumn.TOUR_COST.toString()));
        tour.setDepartureDate(resultSet.getDate(SqlColumn.TOUR_DEPARTURE_DATE.toString()));
        tour.setDays(resultSet.getInt(SqlColumn.TOUR_DAYS.toString()));
        tour.setPlaces(resultSet.getInt(SqlColumn.TOUR_PLACES.toString()));
        TourType tourType = new TourType();
        tourType.setType(resultSet.getString(SqlColumn.TOUR_TYPE.toString()));
        tour.setTourType(tourType);
        tour.setCity(getCityById(resultSet.getInt(SqlColumn.TOUR_CITY_ID.toString())));
        tour.setDepartureCity(getCityById(resultSet.getInt(SqlColumn.TOUR_DEPARTURE_CITY_ID.toString())));
        tour.setHot(resultSet.getBoolean(SqlColumn.TOUR_IS_HOT.toString()));
        Transport transport = new Transport();
        transport.setType(resultSet.getString(SqlColumn.TRANSPORT.toString()));
        tour.setTransport(transport);
        tour.setDescription(resultSet.getString(SqlColumn.DESCRIPTION.toString()));
    }

    public City getCityById(int id) throws DAOException {
        City city = new City();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_CITY_BY_ID)) {
            statement.setInt(CITY_ID_QUERY_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    city.setCityId(resultSet.getInt(SqlColumn.CITY_ID.toString()));
                    city.setCity(resultSet.getString(SqlColumn.CITY.toString()));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return city;
    }

    private static final class TourDAOImplHolder {
        private static final TourDAOImpl INSTANCE = new TourDAOImpl();
    }
}
