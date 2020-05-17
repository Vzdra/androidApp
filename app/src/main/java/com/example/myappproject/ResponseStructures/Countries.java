package com.example.myappproject.ResponseStructures;

public class Countries {
    private String status;
    private Country country;

    public Countries(String status, Country country) {
        this.status = status;
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public Country getCountry() {
        return country;
    }
}
