package by.epam.agency.service.impl;

import by.epam.agency.dao.TransportDAO;
import by.epam.agency.entity.Transport;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.TransportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TransportServiceImpl implements TransportService {

    private static final Logger LOGGER = LogManager.getLogger(TransportServiceImpl.class.getName());
    private TransportDAO transportDAO = DAOFactory.getInstance().getTransportDAO();

    private TransportServiceImpl() {

    }

    public static TransportServiceImpl getInstance() {
        return TransportServiceImpl.TransportServiceImplHolder.INSTANCE;
    }

    @Override
    public Transport findTransportById(int id) throws ServiceException {
        try {
            return transportDAO.findById(id);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Transport> getAllTransports() throws ServiceException {
        try {
            return transportDAO.getAll();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    private static final class TransportServiceImplHolder {
        private static final TransportServiceImpl INSTANCE = new TransportServiceImpl();
    }
}
