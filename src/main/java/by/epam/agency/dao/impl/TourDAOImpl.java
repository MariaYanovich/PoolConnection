package by.epam.agency.dao.impl;

import by.epam.agency.dao.TourDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.entity.City;
import by.epam.agency.entity.Tour;
import by.epam.agency.entity.TourType;
import by.epam.agency.entity.Transport;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TourDAOImpl implements TourDAO {

    private static final Logger LOGGER = LogManager.getLogger(TourDAOImpl.class.getName());

    private static final int CREATE_TOUR_NAME_INDEX = 1;
    private static final int CREATE_TOUR_COST_INDEX = 2;
    private static final int CREATE_TOUR_DEPARTURE_DATE_INDEX = 3;
    private static final int CREATE_TOUR_DAYS_INDEX = 4;
    private static final int CREATE_TOUR_PLACES_INDEX = 5;
    private static final int CREATE_TOUR_TYPE_INDEX = 6;
    private static final int CREATE_TOUR_CITY_INDEX = 7;
    private static final int CREATE_TOUR_DEPARTURE_CITY_INDEX = 8;
    private static final int CREATE_TOUR_IS_HOT_INDEX = 9;
    private static final int CREATE_TOUR_TRANSPORT_INDEX = 10;
    private static final int CREATE_TOUR_IMAGE_INDEX = 11;
    private static final int CITY_ID_QUERY_INDEX = 1;
    private static final int TOUR_ID_INDEX = 1;


    private TourDAOImpl() {

    }

    public static TourDAO getInstance() {
        return TourDAOImplHolder.INSTANCE;
    }


    @Override
    public void delete(int id) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SQLStatement.DELETE_TOUR)) {
                statement.setInt(TOUR_ID_INDEX, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public void unHotTour(int id) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SQLStatement.UN_HOT_TOUR)) {
                statement.setInt(TOUR_ID_INDEX, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public void setHotTour(int id) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SQLStatement.SET_HOT_TOUR)) {
                statement.setInt(TOUR_ID_INDEX, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public Tour findById(int id) throws DAOException {
        Tour tour = new Tour();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_TOUR_BY_ID)) {
            statement.setInt(CITY_ID_QUERY_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    initializeTourToFindById(tour, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return tour;
    }

    @Override
    public List<Tour> getAll() throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_TOURS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tour tour = new Tour();
                    initializeTourToReturnList(tour, resultSet);
                    listToReturn.add(tour);
                }
            } catch (IOException e) {
                LOGGER.error(e);
                throw new DAOException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }


    @Override
    public void create(Tour tour) throws DAOException {
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.CREATE_TOUR)) {
            initializeStatementToCreateTour(statement, tour);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
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

    @Override
    public List<Tour> getHotTours() throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_TOURS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tour tour = new Tour();
                    initializeTourToReturnList(tour, resultSet);
                    if (tour.isHot()) {
                        listToReturn.add(tour);
                    }
                }
            } catch (IOException e) {
                LOGGER.error(e);
                throw new DAOException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    @Override
    public void delete(Tour item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void update(Tour item) throws DAOException {

    }

    private String getImage(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        inputStream.close();
        outputStream.close();
        return base64Image;
    }

    private void commonInitialize(Tour tour, ResultSet resultSet) throws SQLException, DAOException {
        tour.setTourId(resultSet.getInt(SqlColumn.TOUR_ID.toString()));
        tour.setName(resultSet.getString(SqlColumn.TOUR_NAME.toString()));
        tour.setCost(resultSet.getFloat(SqlColumn.TOUR_COST.toString()));
        tour.setDepartureDate(resultSet.getDate(SqlColumn.TOUR_DEPARTURE_DATE.toString()));
        tour.setDays(resultSet.getInt(SqlColumn.TOUR_DAYS.toString()));
        tour.setPlaces(resultSet.getInt(SqlColumn.TOUR_PLACES.toString()));
        tour.setCity(getCityById(resultSet.getInt(SqlColumn.TOUR_CITY_ID.toString())));
        tour.setDepartureCity(getCityById(resultSet.getInt(SqlColumn.TOUR_DEPARTURE_CITY_ID.toString())));
        tour.setHot(resultSet.getBoolean(SqlColumn.TOUR_IS_HOT.toString()));
    }

    private void initializeTourToFindById(Tour tour, ResultSet resultSet) throws SQLException, DAOException {
        commonInitialize(tour, resultSet);
        TourType tourType = new TourType();
        tourType.setTourTypeId(resultSet.getInt(SqlColumn.TOUR_TYPE_ID.toString()));
        tour.setTourType(tourType);
        Transport transport = new Transport();
        transport.setTransportId(resultSet.getInt(SqlColumn.TRANSPORT_ID.toString()));
        tour.setTransport(transport);
        tour.setImage(resultSet.getBlob(SqlColumn.TOUR_IMAGE.toString()).getBinaryStream());
    }


    private void initializeTourToReturnList(Tour tour, ResultSet resultSet) throws SQLException, DAOException, IOException {
        commonInitialize(tour, resultSet);
        TourType tourType = new TourType();
        tourType.setType(resultSet.getString(SqlColumn.TOUR_TYPE.toString()));
        tour.setTourType(tourType);
        Transport transport = new Transport();
        transport.setType(resultSet.getString(SqlColumn.TRANSPORT.toString()));
        tour.setTransport(transport);
        tour.setImage(resultSet.getBlob(SqlColumn.TOUR_IMAGE.toString()).getBinaryStream());
        tour.setImageString(getImage(tour.getImage()));
    }

    private void initializeStatementToCreateTour(PreparedStatement statement, Tour tour) throws SQLException {
        statement.setString(CREATE_TOUR_NAME_INDEX, tour.getName());
        statement.setFloat(CREATE_TOUR_COST_INDEX, tour.getCost());
        statement.setDate(CREATE_TOUR_DEPARTURE_DATE_INDEX, tour.getDepartureDate());
        statement.setInt(CREATE_TOUR_DAYS_INDEX, tour.getDays());
        statement.setInt(CREATE_TOUR_PLACES_INDEX, tour.getPlaces());
        statement.setInt(CREATE_TOUR_TYPE_INDEX, tour.getTourType().getTourTypeId());
        statement.setInt(CREATE_TOUR_CITY_INDEX, tour.getCity().getCityId());
        statement.setInt(CREATE_TOUR_DEPARTURE_CITY_INDEX, tour.getCity().getCityId());
        statement.setInt(CREATE_TOUR_TRANSPORT_INDEX, tour.getTransport().getTransportId());
        statement.setBoolean(CREATE_TOUR_IS_HOT_INDEX, tour.isHot());
        statement.setBlob(CREATE_TOUR_IMAGE_INDEX, tour.getImage());
    }

    private static final class TourDAOImplHolder {
        private static final TourDAOImpl INSTANCE = new TourDAOImpl();
    }
}
