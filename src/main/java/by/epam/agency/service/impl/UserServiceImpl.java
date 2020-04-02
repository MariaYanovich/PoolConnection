package by.epam.agency.service.impl;

import by.epam.agency.dao.UserDAO;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.exception.ValidatorException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.UserService;
import by.epam.agency.validator.Validator;
import by.epam.agency.validator.type.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());

    private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    private UserServiceImpl() {

    }

    public static UserService getInstance() {
        return UserServiceImplHolder.INSTANCE;
    }

    @Override
    public User signIn(String login, String password) throws ServiceException {
        Validator validator = validateSignInParameters(login, password);
        try {
            validator.validate();
            User user = userDAO.getUserByLoginAndPassword(login, password);
            if (user != null) {
                return user;
            } else {
                LOGGER.error("No such user");
                throw new ServiceException();
            }
        } catch (ValidatorException | DAOException e) {
            LOGGER.error(e);
            throw new ServiceException();
        }
    }

    @Override
    public User signUp(String login, String password, String name, String surname, String cash, String phone) throws ServiceException {
        Validator validator = validateSignUpParameters(login, password, name, surname, Float.parseFloat(cash), phone);
        try {
            validator.validate();
            if (checkLogin(login)) {
                User user = new User(login, password.toCharArray(), name, surname, Float.parseFloat(cash), phone);
                userDAO.create(user);
                return user;
            } else {
                throw new ServiceException();
            }
        } catch (ValidatorException | DAOException e) {
            LOGGER.error(e);
            throw new ServiceException();
        }
    }

    @Override
    public boolean delete() throws ServiceException {
        return false;
    }


    private Validator validateSignInParameters(String login, String password) {
        Validator loginValidator = new LoginValidator(login);
        Validator passwordValidator = new PasswordValidator(password);
        loginValidator.setNext(passwordValidator);
        return loginValidator;
    }

    private Validator validateSignUpParameters(String login, String password, String name, String surname, float cash, String phone) {
        Validator loginValidator = new LoginValidator(login);
        Validator passwordValidator = new PasswordValidator(password);
        Validator nameValidator = new ProperNameValidator(name);
        Validator surnameValidator = new ProperNameValidator(surname);
        Validator cashValidator = new CashValidator(cash);
        Validator phoneValidator = new PhoneValidator(phone);
        loginValidator.setNext(passwordValidator);
        passwordValidator.setNext(nameValidator);
        nameValidator.setNext(surnameValidator);
        surnameValidator.setNext(cashValidator);
        cashValidator.setNext(phoneValidator);
        return loginValidator;
    }

    private boolean checkLogin(String userLogin) throws DAOException {
        String login = userDAO.getLogin(userLogin);
        return login == null;
    }

    private static final class UserServiceImplHolder {
        private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    }
}
