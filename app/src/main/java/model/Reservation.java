package model;

public class Reservation {

    private String timestamp, counterpart, status;

    public Reservation(String timestamp, String counterpart, String status) {
        this.timestamp = timestamp;
        this.counterpart = counterpart;
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCounterpart() {
        return counterpart;
    }

    public String getStatus() {
        return status;
    }
}
