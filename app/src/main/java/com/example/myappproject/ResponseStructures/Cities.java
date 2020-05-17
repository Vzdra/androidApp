package com.example.myappproject.ResponseStructures;

import java.util.List;

public class Cities {
    private String status;
    private List<City> data;

    public Cities(String status, List<City> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public List<City> getCities() {
        return data;
    }
}
