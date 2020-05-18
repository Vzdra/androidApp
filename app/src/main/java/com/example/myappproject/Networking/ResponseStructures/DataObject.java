package com.example.myappproject.Networking.ResponseStructures;

public class DataObject {

    private String city;
    private String state;
    private String country;
    private ResponseLocation location;
    private Current current;

    public DataObject(String city, String state, String country, ResponseLocation location, Current current) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.location = location;
        this.current = current;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public ResponseLocation getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }
}
