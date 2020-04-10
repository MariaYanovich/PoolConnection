package by.epam.agency.command.constants;

public enum PageType {
    HOME_PAGE("/WEB-INF/view/homePage.jsp"),
    SIGN_IN_PAGE("/WEB-INF/view/signIn.jsp"),
    SIGN_UP_PAGE("/WEB-INF/view/signUp.jsp"),
    ERROR_PAGE("/WEB-INF/view/error.jsp"),
    REPEAT_SIGN_IN_PAGE("/WEB-INF/view/repeatSignIn.jsp"),
    ABOUT_PAGE("/WEB-INF/view/about.jsp"),
    SEARCH_PAGE("/WEB-INF/view/search.jsp"),
    CONTACT_PAGE("/WEB-INF/view/contact.jsp"),
    EMPTY_PAGE("");
    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getAddress() {
        return value;
    }
}
