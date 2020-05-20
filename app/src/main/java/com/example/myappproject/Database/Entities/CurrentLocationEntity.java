package com.example.myappproject.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "current_location", primaryKeys = {"country", "state", "city"})
public class CurrentLocationEntity {

    @NotNull
    @ColumnInfo(name = "country")
    private String country;

    @NotNull
    @ColumnInfo(name = "state")
    private String state;

    @NotNull
    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "lat")
    private double lat;

    @ColumnInfo(name = "lon")
    private double lon;

    @ColumnInfo(name = "temperature")
    private int temperature;

    @ColumnInfo(name = "pressure")
    private int pressure;

    @ColumnInfo(name = "humidity")
    private int humidity;

    @ColumnInfo(name = "windspeed")
    private float windspeed;

    @ColumnInfo(name = "winddir")
    private int winddir;

    @ColumnInfo(name = "aqius")
    private int airqualityindex;

    public CurrentLocationEntity(@NotNull String country, @NotNull String state, @NotNull String city, double lat, double lon, int temperature, int pressure, int humidity, float windspeed, int winddir, int airqualityindex) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.winddir = winddir;
        this.airqualityindex = airqualityindex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public int getWinddir() {
        return winddir;
    }

    public void setWinddir(int winddir) {
        this.winddir = winddir;
    }

    public int getAirqualityindex() {
        return airqualityindex;
    }

    public void setAirqualityindex(int airqualityindex) {
        this.airqualityindex = airqualityindex;
    }
}
