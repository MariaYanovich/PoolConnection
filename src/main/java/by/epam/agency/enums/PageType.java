package by.epam.agency.enums;

public enum PageType {
    HOME_PAGE("/WEB-INF/view/homePage.jsp"),
    LOGIN_PAGE("/WEB-INF/view/logIn.jsp"),
    SIGN_IN_PAGE("/WEB-INF/view/signIn.jsp"),
    ERROR_PAGE("/view/error.jsp"),
    RESULT_TABLE_PAGE("/view/table.jsp");

    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
