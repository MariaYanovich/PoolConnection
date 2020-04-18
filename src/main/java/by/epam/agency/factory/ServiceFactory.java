package by.epam.agency.factory;


import by.epam.agency.service.*;
import by.epam.agency.service.impl.*;

public class ServiceFactory {

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }

    public UserService getUserService() {
        return UserServiceImpl.getInstance();
    }

    public TourService getTourService() {
        return TourServiceImpl.getInstance();
    }

    public CityService getCityService() {
        return CityServiceImpl.getInstance();
    }

    public TourTypeService getTourTypeService() {
        return TourTypeServiceImpl.getInstance();
    }

    public TransportService getTransportService() {
        return TransportServiceImpl.getInstance();
    }

    public OrderService getOrderService() {
        return OrderServiceImpl.getInstance();
    }

    private static final class ServiceFactoryHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }


}
