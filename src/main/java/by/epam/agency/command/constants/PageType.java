package by.epam.agency.command.constants;

public enum PageType {
    HOME_PAGE("/WEB-INF/view/homePage.jsp"),
    SIGN_IN_PAGE("/WEB-INF/view/signIn.jsp"),
    SIGN_UP_PAGE("/WEB-INF/view/signUp.jsp"),
    ERROR_PAGE("/WEB-INF/view/error.jsp"),
    CLIENT_PAGE("/WEB-INF/view/clientMenu.jsp"),
    ADMIN_PAGE("/WEB-INF/view/adminMenu.jsp"),
    REPEAT_SIGN_IN_PAGE("/WEB-INF/view/repeatSignIn.jsp");
    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getAddress() {
        return value;
    }
}
