package model;

public class Message {

    private String timestamp, sender;

    public  Message (String timestamp, String sender) {
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return sender;
    }
}
