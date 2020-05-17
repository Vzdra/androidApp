package com.example.myappproject.Networking.Endpoints;

import com.example.myappproject.ResponseStructures.Cities;
import com.example.myappproject.ResponseStructures.Countries;
import com.example.myappproject.ResponseStructures.DataObject;
import com.example.myappproject.ResponseStructures.States;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/nearest_city?lat={lat}&lon={lon}key={apikey}")
    Call<DataObject> nearestCityResults(@Path("apikey") String ki, @Path("lat") double lat, @Path("lon") double lon);

    @GET("/countries?key={apikey}")
    Call<Countries> supportedCountries(@Path("apikey") String ki);

    @GET("/states?country={country}&key={apikey}")
    Call<States> supportedStatesInCountry(@Path("apikey") String ki, @Path("country") String country);

    @GET("/cities?state={state}&country={country}&key={apikey}")
    Call<Cities> supportedCitiesInState(@Path("apikey") String ki, @Path("country") String country, @Path("state") String state);

    @GET("/city?city={city}&state={state}&country={country}&key={apikey}")
    Call<DataObject> cityInformation(@Path("apikey") String ki, @Path("country") String country, @Path("state") String state, @Path("city") String city);

}
