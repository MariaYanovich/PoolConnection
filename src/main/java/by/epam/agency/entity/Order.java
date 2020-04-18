package by.epam.agency.entity;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    private User user;
    private Tour tour;
    private int number;
    private double price;

    public Order() {
    }

    public Order(int orderId, User user, Tour tour, int number, double price) {
        this.orderId = orderId;
        this.user = user;
        this.tour = tour;
        this.number = number;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() &&
                getNumber() == order.getNumber() &&
                Double.compare(order.getPrice(), getPrice()) == 0 &&
                Objects.equals(getUser(), order.getUser()) &&
                Objects.equals(getTour(), order.getTour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getUser(), getTour(), getNumber(), getPrice());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + orderId +
                ", user=" + user +
                ", tour=" + tour +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
