package model;

import java.io.Serializable;

public class Uzer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name, surname, pic, address;
    private float rating;
    private double hourlyPrice=10.50;
    private Role role;

    public Uzer(String name, String surname, String pic, String address, float rating) {
        this.name=name;
        this.surname=surname;
        this.pic= pic;
        this.rating=rating;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
