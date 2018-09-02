package model;

public class ProfileBs {

    private String name, surname, pic, address;
    private float rating;

    public ProfileBs(String name, String surname, String pic, String address, float rating) {
        this.name=name;
        this.surname=surname;
        this.pic= pic;
        this.rating=rating;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
