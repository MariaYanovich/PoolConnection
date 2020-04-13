package by.epam.agency.dao.constants;

public class SQLStatement {

    public static final String CHECK_LOGIN = "SELECT user_login " +
            "FROM travel_agency_db.user where user_login=?";

    public static final String CREATE_USER = "INSERT INTO `travel_agency_db`.`user`" +
            "(`user_login`,`user_password`,`user_name`,`user_surname`," +
            "`user_cash`,`user_phone`) VALUES (?,?,?,?,?,?)";

    public static final String CREATE_ADMIN = "INSERT INTO `travel_agency_db`.`user`" +
            "(`user_login`,`user_password`,`user_name`,`user_surname`," +
            "`user_phone`, `user_role_id`) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, " +
            "user_login, user_password, user_name, user_surname,\n" +
            "user_discount.user_discount_size, user_cash, user_phone, user_role.user_role\n" +
            "FROM travel_agency_db.user join travel_agency_db.user_discount \n" +
            "ON travel_agency_db.user.user_discount_id=travel_agency_db.user_discount.user_discount_id\n" +
            "join travel_agency_db.user_role\n" +
            "ON travel_agency_db.user.user_role_id=travel_agency_db.user_role.user_role_id\n" +
            "WHERE user_login=? and user_password=?";

    public static final String GET_USER_BY_ID = "SELECT user_id, user_login, user_password, user_name," +
            "user_surname, user_discount_id, user_cash, user_phone, user_role_id\n" +
            "FROM travel_agency_db.user\n" +
            "WHERE user_id=?";

    public static final String GET_USER_ROLE_BY_ID = "SELECT user_role_id, user_role" +
            " FROM travel_agency_db.user_role where user_role_id=?";

    public static final String GET_ALL_USERS = "SELECT user.user_id, user.user_login, " +
            "user.user_password,user.user_name, user.user_surname, user_discount.user_discount_size,\n" +
            "user.user_cash, user.user_phone, user_role.user_role\n" +
            "FROM travel_agency_db.user\n" +
            "join travel_agency_db.user_discount \n" +
            "ON travel_agency_db.user.user_discount_id=travel_agency_db.user_discount.user_discount_id\n" +
            "join travel_agency_db.user_role\n" +
            "On travel_agency_db.user.user_role_id=travel_agency_db.user_role.user_role_id\n" +
            "ORDER by user.user_id";

    public static final String BLOCK_USER = "UPDATE `travel_agency_db`.`user` " +
            "SET `user_role_id` = '3' WHERE (`user_id` = ?)";

    public static final String UNBLOCK_USER = "UPDATE `travel_agency_db`.`user`" +
            " SET `user_role_id` = '1' WHERE (`user_id` = ?)";

    public static final String UPDATE_ADMIN_INFO = "UPDATE travel_agency_db.user\n" +
            "SET user_name = ?, user_surname = ?, user_phone = ?\n" +
            "WHERE user_id = ?";

    public static final String UPDATE_CLIENT_INFO = "UPDATE travel_agency_db.user\n" +
            "SET user_name = ?, user_surname = ?, user_phone = ?, user_cash = ?\n" +
            "WHERE user_id = ?";

    public static final String DELETE_CLIENT = "DELETE FROM `travel_agency_db`.`user`\n" +
            "WHERE user_id = ?";

    public static final String GET_ALL_TOURS = "SELECT tour.tour_id, tour.tour_name, " +
            "    tour.tour_cost, tour.tour_departure_date,tour.tour_days,\n" +
            "    tour.tour_places,tour_type.tour_type, tour.tour_city_id, tour.tour_departure_city_id,\n" +
            "    tour.tour_is_hot,transport.transport, tour.tour_image\n" +
            "FROM travel_agency_db.tour\n" +
            "JOIN travel_agency_db.tour_type \n" +
            "ON travel_agency_db.tour.tour_type_id = tour_type.tour_type_id\n" +
            "JOIN travel_agency_db.transport \n" +
            "ON travel_agency_db.tour.tour_transport_id = transport.transport_id "
            + "ORDER by tour.tour_id";

    public static final String GET_CITY_BY_ID = "SELECT * FROM travel_agency_db.city where city_id=?";

    public static final String CREATE_TOUR = "INSERT INTO `travel_agency_db`.`tour`\n" +
            "(`tour_name`, `tour_cost`, `tour_departure_date`,`tour_days`, `tour_places`,`tour_type_id`,\n" +
            "`tour_city_id`, `tour_departure_city_id`, `tour_transport_id`, `tour_is_hot`,\n" +
            "`tour_image`)\n" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

    public static final String GET_TOUR_BY_ID = "SELECT *\n" +
            "FROM `travel_agency_db`.`tour` where tour.tour_id =?";

    public static final String SET_HOT_TOUR = "UPDATE `travel_agency_db`.`tour` " +
            "SET `tour_is_hot` = '1' WHERE (`tour_id` = ?)";

    public static final String UN_HOT_TOUR = "UPDATE `travel_agency_db`.`tour` " +
            "SET `tour_is_hot` = '0' WHERE (`tour_id` = ?)";

    private SQLStatement() {
    }

}