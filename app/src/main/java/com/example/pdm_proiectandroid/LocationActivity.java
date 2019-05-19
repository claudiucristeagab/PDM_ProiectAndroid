package com.example.pdm_proiectandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pdm_proiectandroid.services.LocationService;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


    }

    public void location_btn_click(View view) {
        startService(new Intent(this, LocationService.class));
        //stopService(new Intent(this, LocationService.class));
    }
}
