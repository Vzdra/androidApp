package com.example.myappproject.Networking.ResponseStructures;

import java.util.List;

public class Countries {
    private String status;
    private List<Country> data;

    public Countries(String status, List<Country> country) {
        this.status = status;
        this.data = country;
    }

    public String getStatus() {
        return status;
    }

    public List<Country> getCountry() {
        return data;
    }
}
