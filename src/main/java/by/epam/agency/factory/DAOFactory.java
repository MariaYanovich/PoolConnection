package by.epam.agency.factory;

import by.epam.agency.dao.*;
import by.epam.agency.dao.impl.*;

public class DAOFactory {

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return DAOFactoryHolder.INSTANCE;
    }

    public UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

    public TourDAO getTourDAO() {
        return TourDAOImpl.getInstance();
    }

    public TourTypeDAO getTourTypeDAO() {
        return TourTypeDAOImpl.getInstance();
    }

    public CityDAO getCityDAO() {
        return CityDAOImpl.getInstance();
    }

    public TransportDAO getTransportDAO() {
        return TransportDAOImpl.getInstance();
    }

    public OrderDAO getOrderDAO() {
        return OrderDAOImpl.getInstance();
    }

    private static final class DAOFactoryHolder {
        private static final DAOFactory INSTANCE = new DAOFactory();
    }

}
