package model;

import java.io.Serializable;
import java.util.Calendar;

public class Review implements Serializable{

    private float rating = 2;
    private String text="abcdefghijklsdhfj bsdfhbsdifbsdfisdnf kjsdbnfkid slfsdkf bsdkb fkds fbdsfnnsd" +
            "dhfbsdjfhbsdfisd fjsdf sbdfsd cnbdsncsdcndshcnsdkhncsad nc dsjcsdnc" +
            "fhjsdbhjsdbjsdc sdjc sdcbdsc dscksdnlc,nsd cdscj djcd cdks cdak k";
    private String id="1234566";
    private Calendar timestamp = Calendar.getInstance();
    private Uzer bs=new Uzer(), parent=new Uzer();

    public Review () {
        bs.setRole(Role.BABYSITTER);
        parent.setRole(Role.PARENT);
    }

    public float getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public Uzer getBs() {
        return bs;
    }

    public String getId() {
        return id;
    }

    public Uzer getParent() {
        return parent;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }
}
