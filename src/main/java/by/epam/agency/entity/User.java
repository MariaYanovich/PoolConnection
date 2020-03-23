package by.epam.agency.entity;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private char[] password;
    private String name;
    private String surname;
    private Discount discount;
    private float cash;
    private String phone;
    private String role;

    public User(int id, String username, char[] password, String name,
                String surname, Discount discount, float cash, String phone,
                String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.discount = discount;
        this.cash = cash;
        this.phone = phone;
        this.role = role;
    }

    public User() {
        discount = new Discount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", discount=" + discount +
                ", cash=" + cash +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Float.compare(user.getCash(), getCash()) == 0 &&
                getUsername().equals(user.getUsername()) &&
                Arrays.equals(getPassword(), user.getPassword()) &&
                getName().equals(user.getName()) &&
                getSurname().equals(user.getSurname()) &&
                Objects.equals(getDiscount(), user.getDiscount()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getUsername(), getName(), getSurname(), getDiscount(), getCash(), getPhone(), getRole());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }
}
