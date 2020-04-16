package by.epam.agency.entity;

public enum  TourStatus {

    RELEVANT(3), HOT(2), IRRELEVANT(1);
    private int id;

    TourStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
