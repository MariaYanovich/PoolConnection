package by.epam.agency.entity;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Tour implements Serializable {
    private int tourId;
    private String name;
    private double cost;
    private Date departureDate;
    private int days;
    private int places;
    private TourType tourType;
    private City city;
    private City departureCity;
    private TourStatus tourStatus;
    private Transport transport;
    private transient InputStream image;
    private String imageString;

    public Tour() {
    }

    public Tour(String name, double cost, Date departureDate,
                int days, int places, TourType tourType, City city,
                City departureCity, TourStatus tourStatus, Transport transport,
                InputStream image, String imageString) {
        this(name, cost, departureDate, days, places, tourType, city,
                departureCity, tourStatus, transport, image);
        this.imageString = imageString;
    }

    public Tour(String name, double cost, Date departureDate,
                int days, int places, TourType tourType, City city,
                City departureCity, TourStatus tourStatus, Transport transport,
                InputStream image) {
        this.name = name;
        this.cost = cost;
        this.departureDate = departureDate;
        this.days = days;
        this.places = places;
        this.tourType = tourType;
        this.city = city;
        this.departureCity = departureCity;
        this.tourStatus = tourStatus;
        this.transport = transport;
        this.image = image;
    }

    public Tour(int tourId, String name){
        this.tourId = tourId;
        this.name =name;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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


    public TourStatus getTourStatus() {
        return tourStatus;
    }

    public void setTourStatus(TourStatus tourStatus) {
        this.tourStatus = tourStatus;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return getTourId() == tour.getTourId() &&
                Double.compare(tour.getCost(), getCost()) == 0 &&
                getDays() == tour.getDays() &&
                getPlaces() == tour.getPlaces() &&
                Objects.equals(getName(), tour.getName()) &&
                Objects.equals(getDepartureDate(), tour.getDepartureDate()) &&
                Objects.equals(getTourType(), tour.getTourType()) &&
                Objects.equals(getCity(), tour.getCity()) &&
                Objects.equals(getDepartureCity(), tour.getDepartureCity()) &&
                Objects.equals(getTransport(), tour.getTransport()) &&
                Objects.equals(getImage(), tour.getImage());
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getName(), getCost(),
                getDepartureDate(), getDays(), getPlaces(), getTourType(),
                getCity(), getDepartureCity(), getTransport(), getImage());
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
                ", tourStatus=" + tourStatus +
                ", transport=" + transport +
                ", image='" + image + '\'' +
                "}\n";
    }
}
