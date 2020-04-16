package by.epam.agency.entity;

public enum  TourStatus {

    ACTUAL(1), HOT(2), ARCHIVAL(3);
    private int id;

    TourStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
