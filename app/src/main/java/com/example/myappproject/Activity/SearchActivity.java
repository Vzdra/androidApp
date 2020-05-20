package com.example.myappproject.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.myappproject.Helpers.Types;
import com.example.myappproject.Networking.Client.RetrofitClient;
import com.example.myappproject.Networking.Endpoints.GetDataService;
import com.example.myappproject.Networking.ResponseStructures.Cities;
import com.example.myappproject.Networking.ResponseStructures.Countries;
import com.example.myappproject.Networking.ResponseStructures.DataObject;
import com.example.myappproject.Networking.ResponseStructures.InfoResponse;
import com.example.myappproject.Networking.ResponseStructures.States;
import com.example.myappproject.RecyclerView.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.myappproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private Types type;
    private TextView textView;
    private RecyclerView recyclerView;

    String country;
    String state;
    String city;

    private static String key = "d0aad5b7-d828-4530-9b29-919746a39518";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.tooltip);
        textView.setText("Loading!");
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        Types type = (Types)intent.getSerializableExtra("type");

        if(type!=null){
            if(type == Types.COUNTRY){
                getCountries();
            }else if(type == Types.STATE){
                String country = intent.getStringExtra("country_name");
                getStates(country);
            }else if(type == Types.CITY){
                String country = intent.getStringExtra("country_name");
                String state = intent.getStringExtra("state_name");
                getCity(country, state);
            }else {
                String country = intent.getStringExtra("country_name");
                String state = intent.getStringExtra("state_name");
                String city = intent.getStringExtra("city_name");
                getDetails(country, state, city);
            }

        }else{
            textView.setText("An unexpected error occured :(");
        }
    }


    public void getCountries(){
        GetDataService endpoint = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<Countries> call = endpoint.supportedCountries(key);
        call.enqueue(new Callback<Countries>(){

            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
                if(response.isSuccessful()){
                    if (response.body()!=null){
                        textView.setText("Countries:");
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body().getCountry(), getApplicationContext(), Types.COUNTRY);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    public void getStates(String country){
        GetDataService endpoint = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<States> call = endpoint.supportedStatesInCountry(country, key);
        call.enqueue(new Callback<States>(){

            @Override
            public void onResponse(Call<States> call, Response<States> response) {
                if(response.isSuccessful()){
                    if (response.body()!=null){
                        textView.setText("States:");
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body().getState(), getApplicationContext(), Types.STATE, country);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<States> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    public void getCity(String country, String state){
        GetDataService endpoint = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<Cities> call = endpoint.supportedCitiesInState(state, country, key);
        call.enqueue(new Callback<Cities>(){

            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                if(response.isSuccessful()){
                    if (response.body()!=null){
                        textView.setText("Cities:");
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body().getCities(), getApplicationContext(), Types.CITY, country, state);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    public void getDetails(String country, String state, String city){
        GetDataService endpoint = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<InfoResponse> call = endpoint.cityInformation(city, state, country, key);
        call.enqueue(new Callback<InfoResponse>(){

            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                if(response.isSuccessful()){
                    if (response.body()!=null){
                        DataObject data = response.body().getData();
                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("ct", data.getCountry());
                        intent.putExtra("st", data.getState());
                        intent.putExtra("cy", data.getCity());
                        intent.putExtra("tp", data.getCurrent().getWeather().getTp());
                        intent.putExtra("pr", data.getCurrent().getWeather().getPr());
                        intent.putExtra("hm", data.getCurrent().getWeather().getHu());
                        intent.putExtra("ws", data.getCurrent().getWeather().getWs());
                        intent.putExtra("wd", data.getCurrent().getWeather().getWd());
                        intent.putExtra("aq", data.getCurrent().getPollution().getAqius());
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}
