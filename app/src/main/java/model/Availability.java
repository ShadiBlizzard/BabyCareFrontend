package model;

import java.io.Serializable;
import java.util.Calendar;

public class Availability implements Serializable {

    private Uzer babysitter = new Uzer();
    private Calendar availableDate = Calendar.getInstance();
    private Calendar availabilityStartTime = Calendar.getInstance();
    private Calendar availabilityEndTime = Calendar.getInstance();
    private boolean booked =false;
    private float hourlyPrice = 10.5f;

    public Availability () {
        babysitter.setRole(Role.BABYSITTER);
    }

    public Uzer getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(Uzer babysitter) {
        this.babysitter = babysitter;
    }

    public Calendar getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Calendar availableDate) {
        this.availableDate = availableDate;
    }

    public Calendar getAvailabilityStartTime() {
        return availabilityStartTime;
    }

    public void setAvailabilityStartTime(Calendar availabilityStartTime) {
        this.availabilityStartTime = availabilityStartTime;
    }

    public Calendar getAvailabilityEndTime() {
        return availabilityEndTime;
    }

    public void setAvailabilityEndTime(Calendar availabilityEndTime) {
        this.availabilityEndTime = availabilityEndTime;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public float getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(float hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }
}
