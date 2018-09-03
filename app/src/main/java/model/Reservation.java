package model;


import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable{

    private Calendar start, end, when;
    private ProfileBs bs;
    private ProfilePar pa;
    private LatLng where;
    private AppointmentStatus status;


    public Reservation(LatLng where, Calendar start, Calendar end, Calendar when, ProfilePar parent, ProfileBs babysitter, AppointmentStatus status) {
        this.start = start;
        this.end = end;
        this.when = when;
        this.where = where;
        this.pa = parent;
        this.bs = babysitter;
        this.status = status;

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

    public LatLng getWhere() {
        return where;
    }
    public ProfileBs getBs() {
        return bs;
    }

    public ProfilePar getPa() {
        return pa;
    }
}
