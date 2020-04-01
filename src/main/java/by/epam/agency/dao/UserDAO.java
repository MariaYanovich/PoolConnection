package by.epam.agency.dao;

import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

public interface UserDAO extends DAO<User> {
    String getLogin(String login) throws DAOException;

    User getUserByLoginAndPassword(String login, String password) throws DAOException;
}
