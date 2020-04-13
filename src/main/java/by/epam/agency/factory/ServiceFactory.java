package by.epam.agency.factory;


import by.epam.agency.service.CityService;
import by.epam.agency.service.TourService;
import by.epam.agency.service.TourTypeService;
import by.epam.agency.service.UserService;
import by.epam.agency.service.impl.CityServiceImpl;
import by.epam.agency.service.impl.TourServiceImpl;
import by.epam.agency.service.impl.TourTypeServiceImpl;
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

    public TourService getTourService() {
        return TourServiceImpl.getInstance();
    }

    public CityService getCityService() {
        return CityServiceImpl.getInstance();
    }

    public TourTypeService getTourTypeService() {
        return TourTypeServiceImpl.getInstance();
    }

    private static final class ServiceFactoryHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }


}
