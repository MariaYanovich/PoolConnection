package by.epam.agency.constants;

public class SQLStatement {
    public static final String CHECK_LOGIN = "SELECT user_login " +
            "FROM travel_agency_db.user where user_login=?";

    public static final String CREATE_USER = "INSERT INTO `travel_agency_db`.`user`" +
            "(`user_login`,`user_password`,`user_name`,`user_surname`," +
            "`user_cash`,`user_phone`) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, " +
            "user_login, user_password, user_name, user_surname,\n" +
            "user_discount_id, user_cash, user_phone, user_role_id\n" +
            "FROM travel_agency_db.user\n" +
            "WHERE user_login=? and user_password=?";

    public static final String GET_USER_BY_ID = "SELECT user_id, user_login, user_password, user_name," +
            "user_surname, user_discount_id, user_cash, user_phone, user_role_id\n" +
            "FROM travel_agency_db.user\n" +
            "WHERE user_id=?";

    public static final String GET_ROLE_BY_ID = "SELECT user_role_id, user_role" +
            " FROM travel_agency_db.user_role where user_role_id=?";

    public static final String GET_ALL_USERS = "SELECT * FROM travel_agency_db.user";

}