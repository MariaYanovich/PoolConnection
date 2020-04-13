package by.epam.agency.entity;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Tour implements Serializable {
    private int tourId;
    private String name;
    private float cost;
    private Date departureDate;
    private int days;
    private int places;
    private TourType tourType;
    private City city;
    private City departureCity;
    private boolean isHot;
    private Transport transport;
    private String description;
    private InputStream image;
    private String imageString;

    public Tour() {
    }

    public Tour(String name, float cost, Date departureDate,
                int days, int places, TourType tourType, City city,
                City departureCity, boolean isHot, Transport transport,
                String description, InputStream image, String imageString) {
        this(name, cost, departureDate, days, places, tourType, city,
                departureCity, isHot, transport, description, image);
        this.imageString = imageString;
    }

    public Tour(String name, float cost, Date departureDate,
                int days, int places, TourType tourType, City city,
                City departureCity, boolean isHot, Transport transport,
                String description, InputStream image) {
        this.name = name;
        this.cost = cost;
        this.departureDate = departureDate;
        this.days = days;
        this.places = places;
        this.tourType = tourType;
        this.city = city;
        this.departureCity = departureCity;
        this.isHot = isHot;
        this.transport = transport;
        this.description = description;
        this.image = image;
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


    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
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
                Float.compare(tour.getCost(), getCost()) == 0 &&
                getDays() == tour.getDays() &&
                getPlaces() == tour.getPlaces() &&
                isHot() == tour.isHot() &&
                Objects.equals(getName(), tour.getName()) &&
                Objects.equals(getDepartureDate(), tour.getDepartureDate()) &&
                Objects.equals(getTourType(), tour.getTourType()) &&
                Objects.equals(getCity(), tour.getCity()) &&
                Objects.equals(getDepartureCity(), tour.getDepartureCity()) &&
                Objects.equals(getTransport(), tour.getTransport()) &&
                Objects.equals(getDescription(), tour.getDescription()) &&
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
        return Objects.hash(getTourId(), getName(), getCost(), getDepartureDate(), getDays(), getPlaces(), getTourType(), getCity(), getDepartureCity(), isHot(), getTransport(), getDescription(), getImage());
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
                ", isHot=" + isHot +
                ", transport=" + transport +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                "}\n";
    }
}
