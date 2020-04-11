package by.epam.agency.dao;

import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;

public interface UserDAO extends DAO<User> {
    String findLogin(String login) throws DAOException;

    User findUserByLoginAndPassword(String login, String password) throws DAOException;

    void createAdmin(User user) throws DAOException;

    User blockUser(int id);

    User unblockUser(int id);
}
