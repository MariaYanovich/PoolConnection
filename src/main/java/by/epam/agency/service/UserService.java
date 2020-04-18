package by.epam.agency.service;

import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;

import java.util.List;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    User findUserById(int id) throws ServiceException;

    User signUp(String login, String password, String name, String surname, String cash, String phone) throws ServiceException;

    void createAdmin(String login, String password, String name, String surname, String phone) throws ServiceException;

    void deleteClient(int id) throws ServiceException;

    void blockClient(int id) throws ServiceException;

    void unblockClient(int id) throws ServiceException;

    void updateAdmin(User user) throws ServiceException;

    void updateClient(User user) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    void takeMoney(User user, double amount) throws ServiceException;

    void returnMoney(User user, double amount) throws ServiceException;
}
