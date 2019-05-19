package com.example.pdm_proiectandroid.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;

import com.example.pdm_proiectandroid.entities.Currency;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.example.pdm_proiectandroid.MainActivity.SelectedCurrency;

public class LocationService extends Service {

    private LocationCallback locationCallback = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location position = locationResult.getLastLocation();
            Log.w("GPS",position.getLatitude() +" : "+ position.getLongitude());

            List<Address> addressList = null;
            try {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                addressList = geocoder.getFromLocation(position.getLatitude(), position.getLongitude(), 1);
                String country = addressList.get(0).getCountryName();
                Log.w("GPS", country);
                Currency currency = locationToCurrencyService.getCurrencyByCountry(country);
                SelectedCurrency = currency;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    private LocationRequest locationRequest;
    private LocationManager locationManager;
    private LocationToCurrencyService locationToCurrencyService;

    public LocationService(){
        this.locationToCurrencyService = new LocationToCurrencyService();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        //locationManager.getLastKnownLocation("gps");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
