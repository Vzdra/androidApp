package com.example.myappproject.Networking.Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String baseURL = "api.airvisual.com/v2/";

    public static Retrofit getRetrofitInstance() {
        if(retrofit==null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
