package com.example.pdm_proiectandroid;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.pdm_proiectandroid.services.LocationService;

import static com.example.pdm_proiectandroid.MainActivity.SelectedCurrency;

public class LocationActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_LOCATION = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        TextView countryTextView = findViewById(R.id.location_countryText);
        countryTextView.setText(SelectedCurrency.getName());
    }

    public void location_btn_click(View view) {
        requestPermissions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView countryTextView = findViewById(R.id.location_countryText);
        countryTextView.setText(SelectedCurrency.getName());
    }

    private boolean requestPermissions(){
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        && (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            Log.w("GPS", "Permission granted");
            startService(new Intent(this, LocationService.class));
            return true;
        }
        Log.w("GPS", "Permission denied");
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_PERMISSION_LOCATION);

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startService(new Intent(this, LocationService.class));
            }
        }
    }

    public void location_btn_click2(View view) {
        stopService(new Intent(this, LocationService.class));
        TextView countryTextView = findViewById(R.id.location_countryText);
        countryTextView.setText(SelectedCurrency.getName());
    }
}
