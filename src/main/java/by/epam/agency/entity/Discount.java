package by.epam.agency.entity;

import java.util.Objects;

public class Discount {

    private int id;
    private float discountSize;

    public Discount() {

    }

    public Discount(int id, float discountSize) {
        this.id = id;
        this.discountSize = discountSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(float discountSize) {
        this.discountSize = discountSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;
        Discount that = (Discount) o;
        return getId() == that.getId() &&
                Float.compare(that.getDiscountSize(), getDiscountSize()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiscountSize());
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountID=" + id +
                ", discountSize=" + discountSize +
                '}';
    }
}
