package by.epam.agency.entity;

import java.util.Date;
import java.util.Objects;

public class Tour {
    private int tourId;
    private String name;
    private float cost;
    private Date departureDate;
    private int days;
    private int places;
    private TourType tourType;
    private City city;
    private City departureCity;
    private Discount discount;
    private Transport transport;
    private String description;

    public Tour() {
    }

    public Tour(int tourId, String name, float cost, Date departureDate,
                int days, int places, TourType tourType, City city,
                City departureCity, Discount discount, Transport transport,
                String description) {
        this.tourId = tourId;
        this.name = name;
        this.cost = cost;
        this.departureDate = departureDate;
        this.days = days;
        this.places = places;
        this.tourType = tourType;
        this.city = city;
        this.departureCity = departureCity;
        this.discount = discount;
        this.transport = transport;
        this.description = description;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return getTourId() == tour.getTourId() &&
                Float.compare(tour.getCost(), getCost()) == 0 &&
                getDays() == tour.getDays() &&
                getPlaces() == tour.getPlaces() &&
                Objects.equals(getName(), tour.getName()) &&
                Objects.equals(getDepartureDate(), tour.getDepartureDate()) &&
                Objects.equals(getTourType(), tour.getTourType()) &&
                Objects.equals(getCity(), tour.getCity()) &&
                Objects.equals(getDepartureCity(), tour.getDepartureCity()) &&
                Objects.equals(getDiscount(), tour.getDiscount()) &&
                Objects.equals(getTransport(), tour.getTransport()) &&
                Objects.equals(getDescription(), tour.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getName(), getCost(), getDepartureDate(), getDays(), getPlaces(), getTourType(), getCity(), getDepartureCity(), getDiscount(), getTransport(), getDescription());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", departureDate=" + departureDate +
                ", days=" + days +
                ", places=" + places +
                ", tourType=" + tourType +
                ", city=" + city +
                ", departureCity=" + departureCity +
                ", discount=" + discount +
                ", transport=" + transport +
                ", description='" + description + '\'' +
                '}';
    }
}
