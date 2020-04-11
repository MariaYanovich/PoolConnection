package by.epam.agency.dao;

import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

public interface UserDAO extends DAO<User> {

    String findLogin(String login) throws DAOException;

    User findUserByLoginAndPassword(String login, String password) throws DAOException;

    void createAdmin(User user) throws DAOException;

    void updateAdmin(User item) throws DAOException;

    void blockClient(int id);

    void unblockClient(int id);


}
