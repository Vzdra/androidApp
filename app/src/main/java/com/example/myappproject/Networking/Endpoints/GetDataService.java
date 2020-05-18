package com.example.myappproject.Networking.Endpoints;

import com.example.myappproject.Networking.ResponseStructures.Cities;
import com.example.myappproject.Networking.ResponseStructures.Countries;
import com.example.myappproject.Networking.ResponseStructures.InfoResponse;
import com.example.myappproject.Networking.ResponseStructures.States;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("nearest_city")
    Call<InfoResponse> nearestCityResults(@Query("key") String key);

    @GET("countries")
    Call<Countries> supportedCountries(@Query("key") String key);

    @GET("states")
    Call<States> supportedStatesInCountry(@Query("country") String country, @Query("key") String key);

    @GET("cities")
    Call<Cities> supportedCitiesInState(@Query("state") String state, @Query("country") String country, @Query("key") String key);

    @GET("city")
    Call<InfoResponse> cityInformation(@Query("city") String city, @Query("state") String state, @Query("country") String country, @Query("key") String key);

}
