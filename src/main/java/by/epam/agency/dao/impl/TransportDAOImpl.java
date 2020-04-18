package by.epam.agency.dao.impl;

import by.epam.agency.dao.TransportDAO;
import by.epam.agency.dao.constants.SQLStatement;
import by.epam.agency.dao.constants.SqlColumn;
import by.epam.agency.entity.Transport;
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

public class TransportDAOImpl implements TransportDAO {
    private static final Logger LOGGER = LogManager.getLogger(TransportDAOImpl.class.getName());

    private static final int TRANSPORT_ID_INDEX = 1;

    private TransportDAOImpl() {

    }

    public static TransportDAO getInstance() {
        return TransportDAOImplHolder.INSTANCE;
    }

    @Override
    public void create(Transport item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void delete(Transport item) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public void delete(int id) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    @Override
    public Transport findById(int id) throws DAOException {
        Transport transport = new Transport();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.FIND_TRANSPORT_BY_ID)) {
            statement.setInt(TRANSPORT_ID_INDEX, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    initializeTransport(transport, resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return transport;
    }

    @Override
    public List<Transport> getAll() throws DAOException {
        List<Transport> listToReturn = new ArrayList<>();
        try (ProxyConnection connection = new ProxyConnection(ConnectionPool.INSTANCE.getConnection());
             PreparedStatement statement = connection.prepareStatement(SQLStatement.GET_ALL_TRANSPORT)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Transport transport = new Transport();
                    initializeTransport(transport, resultSet);
                    listToReturn.add(transport);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DAOException(e);
        }
        return listToReturn;
    }

    private void initializeTransport(Transport transport, ResultSet resultSet) throws SQLException {
        transport.setTransportId(resultSet.getInt(SqlColumn.TRANSPORT_ID.toString()));
        transport.setType(resultSet.getString(SqlColumn.TRANSPORT.toString()));
    }

    @Override
    public void update(Transport id) throws DAOException {
        throw new DAOException(new UnsupportedOperationException());
    }

    private static final class TransportDAOImplHolder {
        private static final TransportDAOImpl INSTANCE = new TransportDAOImpl();
    }
}
