package entity;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private char[] password;
    private String name;
    private String username;
    private Discount discount;
    private float cash;
    private String phone;

    public User(int id, String login, char[] password, String name,
                String username, Discount discount, float cash, String phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.username = username;
        this.discount = discount;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                getUsername().equals(user.getUsername()) &&
                getDiscount().equals(user.getDiscount()) &&
                Objects.equals(getPhone(), user.getPhone());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getLogin(), getName(),
                getUsername(), getDiscount(), getCash(), getPhone());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", discount=" + discount +
                ", cash=" + cash +
                ", phone='" + phone + '\'' +
                '}';
    }
}
