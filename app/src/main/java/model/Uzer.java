package model;

import java.io.Serializable;

public class Uzer implements Serializable {

    private static final long serialVersionUID = 1L;
    private float rating=4.5f;
    private PersonalData data = new PersonalData();
    private double hourlyPrice=10.50;
    private Role role;

    public Uzer() {

    }


    public float getRating() {
        return rating;
    }

    public PersonalData getData() {
        return data;
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
