package by.epam.agency.entity;

import java.io.Serializable;
import java.util.Objects;

public class Sale implements Serializable {
    private int saleId;
    private User user;
    private Tour tour;
    private int number;
    private float price;
    private float priceWithDiscount;

    public Sale() {
    }

    public Sale(int saleId, User user, Tour tour, int number, float price, float priceWithDiscount) {
        this.saleId = saleId;
        this.user = user;
        this.tour = tour;
        this.number = number;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(float priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale sale = (Sale) o;
        return getSaleId() == sale.getSaleId() &&
                getNumber() == sale.getNumber() &&
                Float.compare(sale.getPrice(), getPrice()) == 0 &&
                Float.compare(sale.getPriceWithDiscount(), getPriceWithDiscount()) == 0 &&
                Objects.equals(getUser(), sale.getUser()) &&
                Objects.equals(getTour(), sale.getTour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSaleId(), getUser(), getTour(), getNumber(), getPrice(), getPriceWithDiscount());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", user=" + user +
                ", tour=" + tour +
                ", number=" + number +
                ", price=" + price +
                ", priceWithDiscount=" + priceWithDiscount +
                '}';
    }
}
