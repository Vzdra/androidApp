package com.example.myappproject.Networking.ResponseStructures;

import java.util.List;

public class States {
    private String status;
    private List<State> data;

    public States(String status, List<State> state) {
        this.status = status;
        this.data = state;
    }

    public String getStatus() {
        return status;
    }

    public List<State> getState() {
        return data;
    }
}
