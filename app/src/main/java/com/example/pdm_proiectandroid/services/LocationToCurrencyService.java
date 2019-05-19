package com.example.pdm_proiectandroid.services;

import com.example.pdm_proiectandroid.ApiStrings;
import com.example.pdm_proiectandroid.entities.Currency;

public class LocationToCurrencyService {

    public LocationToCurrencyService(){

    }

    public Currency getCurrencyByCountry(String country){
        Currency currency = new Currency();

        switch (country){
            default:{
                currency.setName(ApiStrings.DefaultCurrency);
            }
        }

        return currency;
    }
}
