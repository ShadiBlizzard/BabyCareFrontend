package model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Uzer implements Serializable {

    private static final long serialVersionUID = 1L;
    private float rating=4.5f;
    private PersonalData data = new PersonalData();
    private double hourlyPrice=10.50;
    private Role role;
    private int pic;

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

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }
}
