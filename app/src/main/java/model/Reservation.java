package model;


import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable{

    private Calendar start, end, when;
    private String id="123456789";
    private Availability av;
    private Uzer pa;
    private AppointmentStatus status;


    public Reservation(Calendar start, Calendar end, Calendar when, Uzer parent, Availability av, AppointmentStatus status) {
        this.start = start;
        this.end = end;
        this.when = when;
        this.pa = parent;
        this.av = av;
        this.status = status;
        parent.setRole(Role.PARENT);

    }

    public String getId() {
        return id;
    }

    public AppointmentStatus getStatus() {
        return status;
    }


    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    public Calendar getWhen() {
        return when;
    }

    public Availability getAv() {
        return av;
    }

    public Uzer getPa() {
        return pa;
    }



}
