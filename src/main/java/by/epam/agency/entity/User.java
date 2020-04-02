package by.epam.agency.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private String login;
    private char[] password;
    private String name;
    private String surname;
    private Discount discount;
    private float cash;
    private String phone;
    private UserRole userRole;

    public User(int id, String login, char[] password, String name,
                String surname, Discount discount, float cash, String phone,
                UserRole userRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.discount = discount;
        this.cash = cash;
        this.phone = phone;
        this.userRole = userRole;
    }

    public User(String login, char[] password, String name,
                String surname, float cash, String phone) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.phone = phone;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", discount=" + discount.getId() +
                ", cash=" + cash +
                ", phone='" + phone + '\'' +
                ", role='" + userRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Float.compare(user.getCash(), getCash()) == 0 &&
                getLogin().equals(user.getLogin()) &&
                Arrays.equals(getPassword(), user.getPassword()) &&
                getName().equals(user.getName()) &&
                getSurname().equals(user.getSurname()) &&
                Objects.equals(getDiscount(), user.getDiscount()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                getUserRole().equals(user.getUserRole());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getLogin(), getName(), getSurname(), getDiscount(), getCash(), getPhone(), getUserRole());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }
}
