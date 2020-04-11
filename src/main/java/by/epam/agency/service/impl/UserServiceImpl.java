package by.epam.agency.service.impl;

import by.epam.agency.dao.UserDAO;
import by.epam.agency.entity.Role;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.exception.ValidatorException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.UserService;
import by.epam.agency.validator.Validator;
import by.epam.agency.validator.user.*;
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
        Validator validator = createSignInParametersValidator(login, password);
        try {
            validator.validate();
            User user = userDAO.findUserByLoginAndPassword(login, password);
            if (user != null) {
                return user;
            } else {
                LOGGER.error("No such user");
                throw new ServiceException();
            }
        } catch (ValidatorException | DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User createAdmin(String login, String password, String name, String surname, String phone) throws ServiceException {
        Validator validator = createSignUpAdminParametersValidator(login, password, name, surname, phone);
        try {
            validator.validate();
            if (checkLoginExistence(login)) {
                User user = new User(login, password.toCharArray(), name, surname, phone, Role.ADMIN);
                userDAO.createAdmin(user);
                return user;
            } else {
                throw new ServiceException();
            }
        } catch (ValidatorException | DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User signUp(String login, String password, String name, String surname, String cash, String phone) throws ServiceException {
        Validator validator = createSignUpParametersValidator
                (login, password, name, surname, Float.parseFloat(cash), phone);
        try {
            validator.validate();
            if (checkLoginExistence(login)) {
                User user = new User(login, password.toCharArray(), name, surname, Float.parseFloat(cash), phone);
                userDAO.create(user);
                return user;
            } else {
                throw new ServiceException();
            }
        } catch (ValidatorException | DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete() throws ServiceException {
        throw new ServiceException(new UnsupportedOperationException());
    }

    @Override
    public User blockUser(int id) {
        return userDAO.blockUser(id);
    }

    @Override
    public User unblockUser(int id) {
        return userDAO.unblockUser(id);
    }


    private Validator createSignInParametersValidator(String login, String password) {
        Validator loginValidator = new LoginValidator(login);
        Validator passwordValidator = new PasswordValidator(password);
        loginValidator.setNext(passwordValidator);
        return loginValidator;
    }

    private Validator createSignUpParametersValidator(String login, String password, String name, String surname, float cash, String phone) {
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

    private Validator createSignUpAdminParametersValidator(String login, String password, String name, String surname, String phone) {
        Validator loginValidator = new LoginValidator(login);
        Validator passwordValidator = new PasswordValidator(password);
        Validator nameValidator = new ProperNameValidator(name);
        Validator surnameValidator = new ProperNameValidator(surname);
        Validator phoneValidator = new PhoneValidator(phone);
        loginValidator.setNext(passwordValidator);
        passwordValidator.setNext(nameValidator);
        nameValidator.setNext(surnameValidator);
        surnameValidator.setNext(phoneValidator);
        return loginValidator;
    }

    private boolean checkLoginExistence(String userLogin) throws DAOException {
        String login = userDAO.findLogin(userLogin);
        return login == null;
    }

    private static final class UserServiceImplHolder {
        private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    }
}
