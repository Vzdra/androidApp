package com.example.myappproject.ResponseStructures;

public class InfoResponse {

    private String status;
    private DataObject data;

    public InfoResponse(String status, DataObject data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public DataObject getData() {
        return data;
    }
}
