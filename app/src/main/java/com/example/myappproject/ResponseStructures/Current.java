package com.example.myappproject.ResponseStructures;

public class Current {
    private Weather weather;
    private Pollution pollution;

    public Current(Weather weather, Pollution pollution) {
        this.weather = weather;
        this.pollution = pollution;
    }

    public Weather getWeather() {
        return weather;
    }

    public Pollution getPollution() {
        return pollution;
    }
}
