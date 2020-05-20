package com.example.myappproject.Fragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.myappproject.Database.AppDB;
import com.example.myappproject.Database.Entities.CurrentLocationEntity;
import com.example.myappproject.R;

public class HomeFragment extends Fragment {

    private TextView location;
    private TextView temperature;
    private TextView pressure;
    private TextView humidity;
    private TextView wind;
    private TextView aqi;

    String ctr;
    String stt;
    String cit;
    int tmp;
    int pres;
    int hum;
    float ws;
    int wd;
    int aiqi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctr = getArguments().getString("ct");
        stt = getArguments().getString("st");
        cit = getArguments().getString("cy");
        tmp = getArguments().getInt("tp");
        pres = getArguments().getInt("pr");
        hum = getArguments().getInt("hm");
        ws = getArguments().getFloat("ws");
        wd = getArguments().getInt("wd");
        aiqi = getArguments().getInt("aq");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        location = view.findViewById(R.id.location);
        temperature = view.findViewById(R.id.temperature);
        pressure = view.findViewById(R.id.pressure);
        humidity = view.findViewById(R.id.humidity);
        wind = view.findViewById(R.id.wind);
        aqi = view.findViewById(R.id.air_quality);

        String windDir = "";

        if(!ctr.equals("USA")){
            location.setText(ctr + ", " + cit);
        }else{
            location.setText(ctr + ", " + stt +", " + cit);
        }

        temperature.setText(tmp + " C");
        pressure.setText(pres + " hPa");
        humidity.setText(hum + "%");

        if(wd >= 0 && wd < 22) windDir = "North";
        else if (wd >= 22 && wd < 67) windDir = "North-West";
        else if (wd >= 67 && wd < 112) windDir = "West";
        else if (wd >= 112 && wd < 157) windDir = "South-West";
        else if (wd >= 157 && wd < 202) windDir = "South";
        else if (wd >= 202 && wd < 247) windDir = "South-East";
        else if (wd >= 247 && wd < 292) windDir = "East";
        else if (wd >= 292 && wd < 337) windDir = "North-East";
        else if (wd >= 337) windDir = "North";

        wind.setText(windDir + ", " + ws + "m/h");

        if(aiqi <= 50){
            aqi.setText("Good " + aiqi);
            aqi.setTextColor(Color.GREEN);
        }else if(aiqi > 50 && aiqi <= 100){
            aqi.setText("Moderate " + aiqi);
            aqi.setTextColor(Color.parseColor("#F0AF34"));
        }else if(aiqi > 100 && aiqi <= 150){
            aqi.setText("Unhealthy for sensitive groups " + aiqi);
            aqi.setTextColor(Color.parseColor("#FFA500"));
        }else if(aiqi > 150 && aiqi <= 200){
            aqi.setText("Unhealthy " + aiqi);
            aqi.setTextColor(Color.RED);
        }else if(aiqi > 200){
            aqi.setText("Unhealthy " + aiqi);
            aqi.setTextColor(Color.parseColor("#800080"));
        }

        return view;
    }

    public static HomeFragment getInstance(
            String country,
            String state,
            String city,
            int temperature,
            int pressure,
            int humidity,
            float windspeed,
            int winddir,
            int airquality
    ){

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();

        args.putString("ct", country);
        args.putString("st", state);
        args.putString("cy", city);
        args.putInt("tp", temperature);
        args.putInt("pr", pressure);
        args.putInt("hm", humidity);
        args.putInt("wd", winddir);
        args.putInt("aq", airquality);
        args.putFloat("ws", windspeed);

        fragment.setArguments(args);
        return fragment;
    }
}
