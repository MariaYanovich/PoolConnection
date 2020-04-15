package by.epam.agency.entity;

public enum Role {

    BLOCKED(3), ADMIN(2), CLIENT(1), GUEST(0);
    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
