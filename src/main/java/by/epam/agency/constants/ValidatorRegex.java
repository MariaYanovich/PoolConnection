package by.epam.agency.constants;

public class ValidatorRegex {

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final String PROPER_NAME = "(?i)[a-z]([- ',.a-z]{0,23}[a-z])?";
    public static final String PHONE = "[0-9*#+() -]*";
    public static final String LOGIN = "[A-Za-z0-9_]+";

}
