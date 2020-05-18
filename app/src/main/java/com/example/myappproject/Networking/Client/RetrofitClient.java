package com.example.myappproject.Networking.Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String baseURL = "https://api.airvisual.com/v2/";

    public static Retrofit getRetrofitInstance() {
        if(retrofit==null){

            Gson gson = new GsonBuilder().setLenient().create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
