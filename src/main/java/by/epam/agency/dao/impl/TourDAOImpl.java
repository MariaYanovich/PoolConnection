package by.epam.agency.dao.impl;

import by.epam.agency.dao.TourDAO;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.dao.constants.SqlStatement;
import by.epam.agency.entity.*;
import by.epam.agency.exception.DAOException;
import by.epam.agency.pool.ConnectionPool;
import by.epam.agency.pool.ProxyConnection;
import by.epam.agency.util.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    private static final int CREATE_TOUR_TRANSPORT_INDEX = 9;
    private static final int CREATE_TOUR_IMAGE_INDEX = 10;
    private static final int CITY_ID_QUERY_INDEX = 1;
    private static final int TOUR_ID_INDEX = 1;
    private static final int TOUR_COST_UPDATE_HOT_INDEX = 1;
    private static final int TOUR_ID_UPDATE_HOT_INDEX = 2;
    private static final int UPDATE_TOUR_COST_INDEX = 1;
    private static final int UPDATE_DEPARTURE_DATE_INDEX = 2;
    private static final int UPDATE_TOUR_DAYS_INDEX = 3;
    private static final int UPDATE_TOUR_PLACES_INDEX = 4;
    private static final int UPDATE_TOUR_TYPE_INDEX = 5;
    private static final int UPDATE_TOUR_CITY_INDEX = 6;
    private static final int UPDATE_TOUR_DEPARTURE_CITY_INDEX = 7;
    private static final int UPDATE_TOUR_TRANSPORT_INDEX = 8;
    private static final int UPDATE_TOUR_ID_INDEX = 9;
    private static final double HOT_COEFFICIENT = 0.6;
    private static final int UPDATE_ID_INDEX = 2;
    private static final int UPDATE_PLACES_INDEX = 1;

    private TourDAOImpl() {
    }

    public static TourDAO getInstance() {
        return TourDAOImplHolder.INSTANCE;
    }

    @Override
    public void delete(int tourId) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.DELETE_TOUR)) {
                statement.setInt(TOUR_ID_INDEX, tourId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(Message.DELETE_TOUR_ERROR);
            throw new DAOException(Message.DELETE_TOUR_ERROR, e);
        }
    }

    @Override
    public void update(Tour tour) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_TOUR_INFO)) {
                initializeUpdateTourStatement(statement, tour);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(Message.UPDATE_TOUR_ERROR);
            throw new DAOException(Message.UPDATE_TOUR_ERROR, e);
        }
    }

    @Override
    public void unHotTour(int tourId) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.UN_HOT_TOUR)) {
                statement.setDouble(TOUR_COST_UPDATE_HOT_INDEX,
                        findById(tourId).getCost() * HOT_COEFFICIENT);
                statement.setInt(TOUR_ID_UPDATE_HOT_INDEX, tourId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(Message.UN_HOT_TOUR_ERROR);
            throw new DAOException(Message.UN_HOT_TOUR_ERROR, e);
        }
    }

    @Override
    public void setHotTour(int tourId) throws DAOException {
        try {
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.SET_HOT_TOUR)) {
                statement.setDouble(TOUR_COST_UPDATE_HOT_INDEX,
                        findById(tourId).getCost() / HOT_COEFFICIENT);
                statement.setInt(TOUR_ID_UPDATE_HOT_INDEX, tourId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(Message.SET_HOT_TOUR_ERROR);
            throw new DAOException(Message.SET_HOT_TOUR_ERROR, e);
        }
    }

    @Override
    public Tour findById(int tourId) throws DAOException {
        Tour tour = new Tour();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.FIND_TOUR_BY_ID)) {
            statement.setInt(CITY_ID_QUERY_INDEX, tourId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    initializeTour(tour, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(Message.FIND_TOUR_BY_ID_ERROR);
            throw new DAOException(Message.FIND_TOUR_BY_ID_ERROR, e);
        }
        return tour;
    }

    @Override
    public List<Tour> getAll() throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_TOURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tour tour = new Tour();
                initializeTour(tour, resultSet);
                tour.setImageString(getImage(tour.getImage()));
                listToReturn.add(tour);
            }
        } catch (IOException | SQLException e) {
            LOGGER.error(Message.GET_ALL_TOURS_ERROR);
            throw new DAOException(Message.GET_ALL_TOURS_ERROR, e);
        }
        return listToReturn;
    }

    @Override
    public void create(Tour tour) throws DAOException {
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.CREATE_TOUR)) {
            initializeStatementToCreateTour(statement, tour);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(Message.CREATE_TOUR_ERROR);
            throw new DAOException(Message.CREATE_TOUR_ERROR, e);
        }
    }

    @Override
    public List<Tour> getHotTours() throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_TOURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tour tour = new Tour();
                initializeTour(tour, resultSet);
                tour.setImageString(getImage(tour.getImage()));
                if (tour.getTourStatus().getId() == 2) {
                    listToReturn.add(tour);
                }
            }
        } catch (SQLException | IOException e) {
            LOGGER.error(Message.GET_HOT_TOURS_ERROR);
            throw new DAOException(Message.GET_HOT_TOURS_ERROR, e);
        }
        return listToReturn;
    }

    @Override
    public List<Tour> searchTourByParameters(City city, Date departureDate, int days, double cost) throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_TOURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tour tour = new Tour();
                initializeTour(tour, resultSet);
                tour.setImageString(getImage(tour.getImage()));
                if ((tour.getCity().getCityId() == city.getCityId()) && (departureDate.after(tour.getDepartureDate()))
                        && (days >= tour.getDays()) && (cost >= tour.getCost())) {
                    listToReturn.add(tour);
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error(Message.SEARCH_TOUR_BY_PARAMETERS_ERROR);
            throw new DAOException(Message.SEARCH_TOUR_BY_PARAMETERS_ERROR, e);
        }
        return listToReturn;
    }

    @Override
    public List<Tour> getToursByCityId(int cityId) throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_TOURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tour tour = new Tour();
                initializeTour(tour, resultSet);
                tour.setImageString(getImage(tour.getImage()));
                if (tour.getCity().getCityId() == cityId) {
                    listToReturn.add(tour);
                }
            }
        } catch (SQLException | IOException e) {
            LOGGER.error(Message.GET_TOURS_BY_CITY_ID_ERROR);
            throw new DAOException(Message.GET_TOURS_BY_CITY_ID_ERROR, e);
        }
        return listToReturn;
    }

    @Override
    public List<Tour> getToursByTourTypeId(int tourTypeId) throws DAOException {
        List<Tour> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_TOURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tour tour = new Tour();
                initializeTour(tour, resultSet);
                tour.setImageString(getImage(tour.getImage()));
                if (tour.getTourType().getTourTypeId() == tourTypeId) {
                    listToReturn.add(tour);
                }
            }
        } catch (SQLException | IOException e) {
            LOGGER.error(Message.GET_TOURS_BY_TOUR_TYPE_ID_ERROR);
            throw new DAOException(Message.GET_TOURS_BY_TOUR_TYPE_ID_ERROR, e);
        }
        return listToReturn;
    }

    @Override
    public void buyTour(Tour tour, int amount) throws DAOException {
        try {
            int updatedPlaces = tour.getPlaces() - amount;
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_TOUR_PLACES)) {
                statement.setInt(UPDATE_PLACES_INDEX, updatedPlaces);
                statement.setInt(UPDATE_ID_INDEX, tour.getTourId());
                statement.executeUpdate();
            }
            tour.setPlaces(updatedPlaces);
        } catch (SQLException e) {
            LOGGER.error(Message.BUY_TOUR_ERROR);
            throw new DAOException(Message.BUY_TOUR_ERROR, e);
        }
    }

    @Override
    public void returnTour(Tour tour, int amount) throws DAOException {
        try {
            int updatedPlaces = tour.getPlaces() + amount;
            try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
                 PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_TOUR_PLACES)) {
                statement.setInt(UPDATE_PLACES_INDEX, updatedPlaces);
                statement.setInt(UPDATE_ID_INDEX, tour.getTourId());
                statement.executeUpdate();
            }
            tour.setPlaces(updatedPlaces);
        } catch (SQLException e) {
            LOGGER.error(Message.RETURN_TOUR_ERROR);
            throw new DAOException(Message.RETURN_TOUR_ERROR, e);
        }
    }

    @Override
    public void updateArchivedTours() throws DAOException {
        List<Tour> tours = getAll();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.SET_ARCHIVE_TOUR)) {
            for (Tour tour : tours) {
                if (tour.getDepartureDate().before(Calendar.getInstance().getTime())) {
                    statement.setInt(TOUR_ID_INDEX, tour.getTourId());
                    tour.setTourStatus(TourStatus.ARCHIVAL);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(Message.UPDATE_ARCHIVED_TOURS_ERROR);
            throw new DAOException(Message.UPDATE_ARCHIVED_TOURS_ERROR, e);
        }
    }

    @Override
    public void delete(Tour item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException(
                Message.UNSUPPORTED_OPERATION));
    }

    private City getCityById(int cityId) throws DAOException {
        City city = new City();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SqlStatement.FIND_CITY_BY_ID)) {
            statement.setInt(CITY_ID_QUERY_INDEX, cityId);
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

    private void initializeUpdateTourStatement(PreparedStatement statement, Tour tour) throws SQLException {
        statement.setDouble(UPDATE_TOUR_COST_INDEX, tour.getCost());
        statement.setDate(UPDATE_DEPARTURE_DATE_INDEX, tour.getDepartureDate());
        statement.setInt(UPDATE_TOUR_DAYS_INDEX, tour.getDays());
        statement.setInt(UPDATE_TOUR_PLACES_INDEX, tour.getPlaces());
        statement.setInt(UPDATE_TOUR_TYPE_INDEX, tour.getTourType().getTourTypeId());
        statement.setInt(UPDATE_TOUR_CITY_INDEX, tour.getCity().getCityId());
        statement.setInt(UPDATE_TOUR_DEPARTURE_CITY_INDEX, tour.getDepartureCity().getCityId());
        statement.setInt(UPDATE_TOUR_TRANSPORT_INDEX, tour.getTransport().getTransportId());
        statement.setInt(UPDATE_TOUR_ID_INDEX, tour.getTourId());
    }

    private void initializeTour(Tour tour, ResultSet resultSet) throws SQLException, DAOException {
        tour.setTourId(resultSet.getInt(SqlColumn.TOUR_ID.toString()));
        tour.setName(resultSet.getString(SqlColumn.TOUR_NAME.toString()));
        tour.setCost(resultSet.getDouble(SqlColumn.TOUR_COST.toString()));
        tour.setDepartureDate(resultSet.getDate(SqlColumn.TOUR_DEPARTURE_DATE.toString()));
        tour.setDays(resultSet.getInt(SqlColumn.TOUR_DAYS.toString()));
        tour.setPlaces(resultSet.getInt(SqlColumn.TOUR_PLACES.toString()));
        tour.setCity(getCityById(resultSet.getInt(SqlColumn.TOUR_CITY_ID.toString())));
        tour.setDepartureCity(getCityById(resultSet.getInt(SqlColumn.TOUR_DEPARTURE_CITY_ID.toString())));
        tour.setTourStatus(TourStatus.valueOf(resultSet.getString(SqlColumn.TOUR_STATUS.toString()).toUpperCase()));
        tour.setTourType(new TourType(resultSet.getInt(SqlColumn.TOUR_TYPE_ID.toString()),
                resultSet.getString(SqlColumn.TOUR_TYPE.toString())));
        tour.setTransport(new Transport(resultSet.getInt(SqlColumn.TRANSPORT_ID.toString()),
                resultSet.getString(SqlColumn.TRANSPORT.toString())));
        tour.setImage(resultSet.getBlob(SqlColumn.TOUR_IMAGE.toString()).getBinaryStream());
    }

    private void initializeStatementToCreateTour(PreparedStatement statement, Tour tour) throws SQLException {
        statement.setString(CREATE_TOUR_NAME_INDEX, tour.getName());
        statement.setDouble(CREATE_TOUR_COST_INDEX, tour.getCost());
        statement.setDate(CREATE_TOUR_DEPARTURE_DATE_INDEX, tour.getDepartureDate());
        statement.setInt(CREATE_TOUR_DAYS_INDEX, tour.getDays());
        statement.setInt(CREATE_TOUR_PLACES_INDEX, tour.getPlaces());
        statement.setInt(CREATE_TOUR_TYPE_INDEX, tour.getTourType().getTourTypeId());
        statement.setInt(CREATE_TOUR_CITY_INDEX, tour.getCity().getCityId());
        statement.setInt(CREATE_TOUR_DEPARTURE_CITY_INDEX, tour.getCity().getCityId());
        statement.setInt(CREATE_TOUR_TRANSPORT_INDEX, tour.getTransport().getTransportId());
        statement.setBlob(CREATE_TOUR_IMAGE_INDEX, tour.getImage());
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

    private static final class TourDAOImplHolder {
        private static final TourDAOImpl INSTANCE = new TourDAOImpl();
    }
}
