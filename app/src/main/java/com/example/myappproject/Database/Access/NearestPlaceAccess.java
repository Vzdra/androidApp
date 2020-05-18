package com.example.myappproject.Database.Access;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.myappproject.Database.Entities.CurrentLocationEntity;

@Dao
public interface NearestPlaceAccess {

    @Query("select * from current_location limit 1")
    CurrentLocationEntity getCurrent();

    @Query("delete from current_location")
    void nukeTable();

    @Query("insert into current_location(country, state, city, lat, lon, temperature, pressure, humidity, windspeed, winddir, aqius) " +
            "values(:country,:state,:city,:lat,:lon,:temper,:press,:humidity,:windspeed,:winddir,:aqius)")
    void insertLocation(
            String country,
            String state,
            String city,
            double lat,
            double lon,
            int temper,
            int press,
            int humidity,
            int windspeed,
            int winddir,
            int aqius
    );
}
