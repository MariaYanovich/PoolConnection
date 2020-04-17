package by.epam.agency.dao.constants;

public class SQLStatement {

    public static final String CHECK_LOGIN = "SELECT user_login " +
            "FROM travel_agency_db.user where user_login=?";

    public static final String CREATE_CLIENT = "INSERT INTO `travel_agency_db`.`user`" +
            "(`user_login`,`user_password`,`user_name`,`user_surname`," +
            "`user_cash`,`user_phone`) VALUES (?,?,?,?,?,?)";

    public static final String CREATE_ADMIN = "INSERT INTO `travel_agency_db`.`user`" +
            "(`user_login`,`user_password`,`user_name`,`user_surname`," +
            "`user_phone`, `user_role_id`) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, user_login, user_password, user_name, user_surname,\n" +
            "user_discount.user_discount_id, user_discount.user_discount_size, user_cash, \n" +
            "user_phone, user_role.user_role_id, user_role.user_role\n" +
            "FROM travel_agency_db.user\n" +
            "inner join travel_agency_db.user_discount \n" +
            "ON travel_agency_db.user.user_discount_id=travel_agency_db.user_discount.user_discount_id\n" +
            "inner join travel_agency_db.user_role\n" +
            "ON travel_agency_db.user.user_role_id=travel_agency_db.user_role.user_role_id " +
            "WHERE user_login=? and user_password=?";

    public static final String GET_USER_BY_ID = "SELECT user_id, user_login, user_password, user_name, user_surname,\n" +
            "user_discount.user_discount_id, user_discount.user_discount_size, user_cash, \n" +
            "user_phone, user_role.user_role_id, user_role.user_role\n" +
            "FROM travel_agency_db.user\n" +
            "inner join travel_agency_db.user_discount \n" +
            "ON travel_agency_db.user.user_discount_id=travel_agency_db.user_discount.user_discount_id\n" +
            "inner join travel_agency_db.user_role\n" +
            "ON travel_agency_db.user.user_role_id=travel_agency_db.user_role.user_role_id " +
            "WHERE user_id=?";

    public static final String GET_ALL_USERS = "SELECT user_id, user_login, user_password, user_name, user_surname,\n" +
            "user_discount.user_discount_id, user_discount.user_discount_size, user_cash, \n" +
            "user_phone, user_role.user_role_id, user_role.user_role\n" +
            "FROM travel_agency_db.user\n" +
            "inner join travel_agency_db.user_discount \n" +
            "ON travel_agency_db.user.user_discount_id=travel_agency_db.user_discount.user_discount_id\n" +
            "inner join travel_agency_db.user_role\n" +
            "ON travel_agency_db.user.user_role_id=travel_agency_db.user_role.user_role_id " +
            "ORDER by user.user_id";

    public static final String BLOCK_USER = "UPDATE `travel_agency_db`.`user` " +
            "SET `user_role_id` = '3' WHERE (`user_id` = ?)";

    public static final String UNBLOCK_USER = "UPDATE `travel_agency_db`.`user`" +
            " SET `user_role_id` = '1' WHERE (`user_id` = ?)";

    public static final String UPDATE_ADMIN_INFO = "UPDATE travel_agency_db.user\n" +
            "SET user_name = ?, user_surname = ?, user_phone = ?\n" +
            "WHERE user_id = ?;";

    public static final String UPDATE_CLIENT_INFO = "UPDATE travel_agency_db.user\n" +
            "SET user_name = ?, user_surname = ?, user_phone = ?, user_cash = ?\n" +
            "WHERE user_id = ?";

    public static final String DELETE_CLIENT = "DELETE FROM `travel_agency_db`.`user`\n" +
            "WHERE user_id = ?";

    public static final String CREATE_CITY = "INSERT INTO `travel_agency_db`.`city`" +
            "(`city`) VALUES (?)";

    public static final String DELETE_CITY = "DELETE FROM `travel_agency_db`.`city`\n" +
            "WHERE city_id = ?";

    public static final String GET_CITY_BY_ID = "SELECT * FROM travel_agency_db.city where city_id=?";

    public static final String GET_ALL_CITIES = "SELECT * FROM travel_agency_db.city"
            + " ORDER by city.city";

    public static final String CHECK_CITY = "SELECT city " +
            "FROM travel_agency_db.city where city.city=?";

    public static final String CREATE_TOUR = "INSERT INTO `travel_agency_db`.`tour`\n" +
            "(`tour_name`, `tour_cost`, `tour_departure_date`,`tour_days`, `tour_places`,`tour_type_id`,\n" +
            "`tour_city_id`, `tour_departure_city_id`, `tour_transport_id`, \n" +
            "`tour_image`)\n" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";

    public static final String CREATE_TOUR_TYPE = "INSERT INTO `travel_agency_db`.`tour_type`" +
            "(`tour_type`) VALUES (?)";

    public static final String DELETE_TOUR_TYPE = "DELETE FROM `travel_agency_db`.`tour_type`\n" +
            "WHERE tour_type_id = ?";

    public static final String GET_TOUR_TYPE_BY_ID = "SELECT * FROM travel_agency_db.tour_type " +
            "WHERE tour_type_id=?";

    public static final String GET_ALL_TOUR_TYPES = "SELECT * FROM travel_agency_db.tour_type " +
            "ORDER by tour_type_id";

    public static final String CHECK_TOUR_TYPE = "SELECT tour_type " +
            "FROM travel_agency_db.tour_type where tour_type.tour_type=?";

    public static final String GET_TRANSPORT_BY_ID = "SELECT * FROM travel_agency_db.transport " +
            "WHERE transport_id=?";

    public static final String GET_ALL_TRANSPORT = "SELECT * FROM travel_agency_db.transport " +
            "ORDER by transport_id";

    public static final String GET_ALL_TOURS = "SELECT tour.tour_id, tour.tour_name, tour.tour_cost, tour.tour_departure_date, tour.tour_days, \n" +
            "tour.tour_places, tour_type.tour_type_id, tour_type.tour_type, tour.tour_city_id, tour.tour_departure_city_id,\n" +
            "tour_status.tour_status_id,  tour_status.tour_status, transport.transport_id, transport.transport, tour.tour_image \n" +
            "FROM travel_agency_db.tour\n" +
            "right join travel_agency_db.tour_type\n" +
            "ON travel_agency_db.tour.tour_type_id = tour_type.tour_type_id\n" +
            "right join travel_agency_db.transport\n" +
            "ON travel_agency_db.tour.tour_transport_id = transport.transport_id \n" +
            "right join travel_agency_db.tour_status\n" +
            "ON travel_agency_db.tour.tour_status_id = tour_status.tour_status_id \n" +
            "WHERE tour_id is not null" +
            " ORDER by tour.tour_departure_date";

    public static final String GET_TOUR_BY_ID = "SELECT tour.tour_id, tour.tour_name, tour.tour_cost, tour.tour_departure_date, tour.tour_days, \n" +
            "tour.tour_places, tour_type.tour_type_id, tour_type.tour_type, tour.tour_city_id, tour.tour_departure_city_id,\n" +
            "tour_status.tour_status_id,  tour_status. tour_status, transport.transport_id, transport.transport, tour.tour_image \n" +
            "FROM travel_agency_db.tour\n" +
            "right join travel_agency_db.tour_type\n" +
            "ON travel_agency_db.tour.tour_type_id = tour_type.tour_type_id\n" +
            "right join travel_agency_db.transport\n" +
            "ON travel_agency_db.tour.tour_transport_id = transport.transport_id \n" +
            "right join travel_agency_db.tour_status\n" +
            "ON travel_agency_db.tour.tour_status_id = tour_status.tour_status_id \n" +
            "where tour.tour_id =?";

    public static final String UPDATE_TOUR_INFO = "UPDATE travel_agency_db.tour\n" +
            "SET " +
            "tour.tour_cost =? , tour.tour_departure_date =?, tour.tour_days =? , \n" +
            "tour.tour_places =? , tour.tour_type_id =? ,tour.tour_city_id =? , tour.tour_departure_city_id =? ,\n" +
            "tour.tour_transport_id =?  " +
            "WHERE tour_id = ?";

    public static final String SET_HOT_TOUR = "UPDATE `travel_agency_db`.`tour` " +
            "SET `tour_status_id` = '2' WHERE (`tour_id` = ?)";

    public static final String UN_HOT_TOUR = "UPDATE `travel_agency_db`.`tour` " +
            "SET `tour_status_id` = '1' WHERE (`tour_id` = ?)";

    public static final String SET_ARCHIVE_TOUR = "UPDATE `travel_agency_db`.`tour` " +
            "SET `tour_status_id` = '3' WHERE (`tour_id` = ?)";

    public static final String DELETE_TOUR = "DELETE FROM `travel_agency_db`.`tour`\n" +
            "WHERE tour_id = ?";

    private SQLStatement() {
    }

}