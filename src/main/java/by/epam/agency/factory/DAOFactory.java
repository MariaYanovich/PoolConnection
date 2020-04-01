package by.epam.agency.factory;

import by.epam.agency.dao.RoleDAO;
import by.epam.agency.dao.UserDAO;
import by.epam.agency.dao.impl.RoleDAOImpl;
import by.epam.agency.dao.impl.UserDAOImpl;

public class DAOFactory {
    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return DAOFactoryHolder.INSTANCE;
    }

    public UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

    public RoleDAO getRoleDAO() {
        return RoleDAOImpl.getInstance();
    }

    private static final class DAOFactoryHolder {
        private static final DAOFactory INSTANCE = new DAOFactory();
    }

}
