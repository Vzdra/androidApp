package com.example.myappproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.example.myappproject.Fragment.HomeFragment;
import com.example.myappproject.R;

public class DetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = findViewById(R.id.toolbar_details);

        if(toolbar!=null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            toolbar.setTitle("Details");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        String ct = intent.getStringExtra("ct");
        String st = intent.getStringExtra("st");
        String ci = intent.getStringExtra("cy");
        int tp = intent.getIntExtra("tp", 0);
        int pr = intent.getIntExtra("pr", 0);
        int hu = intent.getIntExtra("hm", 0);
        int wd = intent.getIntExtra("wd", 0);
        float ws = intent.getFloatExtra("ws", 0);
        int aiq = intent.getIntExtra("aq", 0);

        HomeFragment homeFragment = HomeFragment.getInstance(ct, st, ci, tp, pr, hu, ws, wd, aiq);

        getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment_container, homeFragment).commit();
    }
}
