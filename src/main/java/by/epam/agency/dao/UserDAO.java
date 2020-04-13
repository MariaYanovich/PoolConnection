package by.epam.agency.dao;

import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

public interface UserDAO extends DAO<User> {

    String findLogin(String login) throws DAOException;

    User findUserByLoginAndPassword(String login, String password) throws DAOException;

    void createClient(User user) throws DAOException;

    void createAdmin(User user) throws DAOException;

    void deleteClient(int id) throws DAOException;

    void updateClient(User user) throws DAOException;

    void updateAdmin(User user) throws DAOException;

    void blockClient(int id) throws DAOException;

    void unblockClient(int id) throws DAOException;


}
