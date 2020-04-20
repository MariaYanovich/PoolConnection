package by.epam.agency.service.impl;

import by.epam.agency.dao.OrderDAO;
import by.epam.agency.entity.Order;
import by.epam.agency.entity.User;
import by.epam.agency.exception.DAOException;
import by.epam.agency.exception.ServiceException;
import by.epam.agency.factory.DAOFactory;
import by.epam.agency.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class.getName());

    private OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();

    private OrderServiceImpl() {

    }

    public static OrderService getInstance() {
        return OrderServiceImplHolder.INSTANCE;
    }

    @Override
    public void createOrder(Order order) throws ServiceException {
        try {
            orderDAO.create(order);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteOrder(int orderId) throws ServiceException {
        try {
            orderDAO.delete(orderId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Order findOrderById(int orderId) throws ServiceException {
        try {
            return orderDAO.findById(orderId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getAllOrders() throws ServiceException {
        try {
            return orderDAO.getAll();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) throws ServiceException {
        try {
            return orderDAO.getOrdersByUserId(userId);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateOrdersStatus() throws ServiceException {
        try {
            orderDAO.updateOrdersStatus();
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserDiscount(User user) throws ServiceException {
        try {
            orderDAO.updateUserDiscount(user);
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e);
        }
    }

    private static final class OrderServiceImplHolder {
        private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
    }
}
