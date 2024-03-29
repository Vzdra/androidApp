package com.example.myappproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.example.myappproject.Database.AppDB;
import com.example.myappproject.Database.Entities.CurrentLocationEntity;
import com.example.myappproject.Fragment.HomeFragment;
import com.example.myappproject.Fragment.MapFragment;
import com.example.myappproject.Helpers.Types;
import com.example.myappproject.R;
import com.example.myappproject.Service.GetLocationInterval;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    AppDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        db = AppDB.getDBInstance(this);

        startService(new Intent(this, GetLocationInterval.class));

        if(db.nearestPlaceAccess().getCurrent()!=null){

            BottomNavigationView bottomNavView = findViewById(R.id.navigation_bar);
            bottomNavView.setOnNavigationItemSelectedListener(navListener);

            HomeFragment frag = returnHomeFrag();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

        }else{

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    BottomNavigationView bottomNavView = findViewById(R.id.navigation_bar);
                    bottomNavView.setOnNavigationItemSelectedListener(navListener);

                    HomeFragment frag = returnHomeFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();
                }
            }, 2000);

        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectedFragment = returnHomeFrag();
                            break;
                        case R.id.navigation_map:
                            selectedFragment = returnMapFrag();
                            break;
                        case R.id.navigation_search:
                            Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                            intent.putExtra("type", Types.COUNTRY);
                            startActivity(intent);
                            break;
                    }

                    if(selectedFragment!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    }

                    return true;
                }
            };

    private CurrentLocationEntity queryNearest(){
        return db.nearestPlaceAccess().getCurrent();
    }

    private HomeFragment returnHomeFrag(){
        CurrentLocationEntity tt = queryNearest();
        return HomeFragment.getInstance(tt.getCountry(),tt.getState(),tt.getCity(),tt.getTemperature(),tt.getPressure(),tt.getHumidity(),tt.getWindspeed(),tt.getWinddir(),tt.getAirqualityindex());
    }

    private MapFragment returnMapFrag(){
        CurrentLocationEntity tt = queryNearest();
        return MapFragment.newInstance(tt.getLat(), tt.getLon(), tt.getAirqualityindex());
    }
}
