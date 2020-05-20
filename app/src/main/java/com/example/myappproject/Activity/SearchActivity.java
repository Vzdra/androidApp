package com.example.myappproject.Activity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.myappproject.Networking.Client.RetrofitClient;
import com.example.myappproject.Networking.Endpoints.GetDataService;
import com.example.myappproject.Networking.ResponseStructures.Countries;
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

    boolean searchCtry;
    boolean searchCity;
    boolean searchState;

    TextView textView;
    RecyclerView recyclerView;

    private static String key = "d0aad5b7-d828-4530-9b29-919746a39518";

    String ctry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.tooltip);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        getCountries();
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
                        textView.setTextColor(Color.BLUE);
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body().getCountry(), getApplicationContext());
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
}
