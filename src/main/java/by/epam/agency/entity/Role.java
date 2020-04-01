package by.epam.agency.entity;

public enum Role {

    ADMIN(2), CLIENT(1), GUEST(0);
    private int id;

    private Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
