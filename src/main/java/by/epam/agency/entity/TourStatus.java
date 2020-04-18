package by.epam.agency.entity;

import java.io.Serializable;

public enum TourStatus implements Serializable {
    ACTUAL(1), HOT(2), ARCHIVAL(3), SOLD(4);
    private int id;

    TourStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
