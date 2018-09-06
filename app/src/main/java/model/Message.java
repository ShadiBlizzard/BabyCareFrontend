package model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Calendar;

public class Message implements Serializable{

    private Calendar timestamp = Calendar.getInstance();
    private String txt ="ambarabaciccicocco";
    private Reservation res = new Reservation(45.4642035, 9.186515999999983, Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance(), new Uzer("mozzarella", "volante", "pic", "Milano, piazza leonardo", 5), new Uzer("sbiribilla", "volante", "pic", "Milano, piazza leonardo", 5), AppointmentStatus.REQUESTED);


    public  Message () {
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public Reservation getRes() {
        return res;
    }

    public String getTxt() {
        return txt;
    }
}
