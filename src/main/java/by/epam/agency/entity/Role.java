package by.epam.agency.entity;

import java.io.Serializable;

public enum Role implements Serializable {

    BLOCKED(3), ADMIN(2), CLIENT(1), GUEST(0);
    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
