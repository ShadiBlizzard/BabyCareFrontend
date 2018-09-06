package model;

import java.io.Serializable;

public class PersonalData implements Serializable {

    private String name="name";
    private String surname="surname";
    private String address = "milano, via spinoza";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
