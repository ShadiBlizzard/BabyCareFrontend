package model;


import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable{

    private Calendar start, end, when;
    private Uzer bs;
    private Uzer pa;
    private Double lat;
    private Double longi;
    private AppointmentStatus status;


    public Reservation(Double lat, Double lng, Calendar start, Calendar end, Calendar when, Uzer parent, Uzer babysitter, AppointmentStatus status) {
        this.start = start;
        this.end = end;
        this.when = when;
        this.lat = lat;
        this.longi = lng;
        this.pa = parent;
        this.bs = babysitter;
        this.status = status;
        parent.setRole(Role.PARENT);
        babysitter.setRole(Role.BABYSITTER);

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

    public Uzer getBs() {
        return bs;
    }

    public Uzer getPa() {
        return pa;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLongi() {
        return longi;
    }


}
