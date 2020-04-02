package by.epam.agency.entity;

public enum UserRole {

    ADMIN(2), CLIENT(1), GUEST(0);
    private int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
