package entity;

import java.util.Objects;

public class Discount {

    private int discountID;
    private float discountSize;

    public Discount() {

    }

    public Discount(int discountID, float discountSize) {
        this.discountID = discountID;
        this.discountSize = discountSize;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
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
        return getDiscountID() == that.getDiscountID() &&
                Float.compare(that.getDiscountSize(), getDiscountSize()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountID(), getDiscountSize());
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountID=" + discountID +
                ", discountSize=" + discountSize +
                '}';
    }
}
