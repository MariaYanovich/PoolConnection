package by.epam.agency.service;

import by.epam.agency.entity.User;
import by.epam.agency.exception.ServiceException;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    User signUp(String login, String password, String name, String surname, String cash, String phone) throws ServiceException;

    boolean delete() throws ServiceException;

}
