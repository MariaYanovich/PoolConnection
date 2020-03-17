package enums;

public enum TransportType {
    AIR("1"), RAILWAY("2"), CAR("3"), SAILING("4");

    private String value;

    TransportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
