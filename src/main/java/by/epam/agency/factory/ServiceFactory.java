package by.epam.agency.factory;


import by.epam.agency.service.UserService;
import by.epam.agency.service.impl.UserServiceImpl;

public class ServiceFactory {
    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    public UserService getUserService() {
        return UserServiceImpl.getInstance();
    }

    private static final class ServiceFactoryHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }


}
