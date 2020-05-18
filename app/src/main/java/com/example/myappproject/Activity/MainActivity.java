package com.example.myappproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myappproject.Fragment.HomeFragment;
import com.example.myappproject.Networking.Client.RetrofitClient;
import com.example.myappproject.Networking.Endpoints.GetDataService;
import com.example.myappproject.R;
import com.example.myappproject.ResponseStructures.City;
import com.example.myappproject.ResponseStructures.DataObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        HomeFragment currentFragment;
        currentFragment = new HomeFragment();

        BottomNavigationView bottomNavView = findViewById(R.id.navigation_bar);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
        //currentFragment.setTextView("Hello playa!");

        //=--------------------------------------
//        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
//        Call<DataObject> call = service.cityInformation("d0aad5b7-d828-4530-9b29-919746a39518", "North Macedonia", "Skopje", "Skopje");
//        call.enqueue(new Callback<DataObject>() {
//            @Override
//            public void onResponse(Call<DataObject> call, Response<DataObject> response) {
//                ((HomeFragment) currentFragment).setTextView(response.body().getState());
//            }
//
//            @Override
//            public void onFailure(Call<DataObject> call, Throwable t) {
//                System.out.println(t);
//            }
//        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = new HomeFragment();

                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };
}
