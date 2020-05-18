package com.example.myappproject.Networking.ResponseStructures;

public class ResponseLocation {

    private String type;
    private double[] coordinates;

    public ResponseLocation(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}
