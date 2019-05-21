package com.example.pdm_proiectandroid.services;

import com.example.pdm_proiectandroid.ApiStrings;
import com.example.pdm_proiectandroid.entities.Currency;

public class LocationToCurrencyService {

    public LocationToCurrencyService(){

    }

    public Currency getCurrencyByCountry(String country){
        Currency currency = new Currency();

        switch (country){
            case "Canada":{
                currency.setName("CAD");
                break;
            }
            case "România":{
                currency.setName("RON");
                break;
            }
            case "Switzerland":{
                currency.setName("CHF");
                break;
            }
            case "United States":{
                currency.setName("USD");
                break;
            }
            default:{
                currency.setName(ApiStrings.DefaultCurrency);
                break;
            }
        }

        return currency;
    }
}
