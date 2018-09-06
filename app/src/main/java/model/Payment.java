package model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Calendar;

public class Payment implements Serializable{

    private Reservation appointment = new Reservation( Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), new Uzer(), new Availability(), AppointmentStatus.REQUESTED);
    private Calendar creationDate = Calendar.getInstance();
    private Double amount=3.0;
    private String id="1234567890";
    private boolean paid=false, canceled=false;
    private Calendar paidDate= Calendar.getInstance(), datetimeCancelled = Calendar.getInstance();


    public Reservation getAppointment() {
        return appointment;
    }

    public void setAppointment(Reservation appointment) {
        this.appointment = appointment;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Calendar getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Calendar paidDate) {
        this.paidDate = paidDate;
    }

    public Calendar getDatetimeCancelled() {
        return datetimeCancelled;
    }

    public void setDatetimeCancelled(Calendar datetimeCancelled) {
        this.datetimeCancelled = datetimeCancelled;
    }

    public String getId() {
        return id;
    }
}
