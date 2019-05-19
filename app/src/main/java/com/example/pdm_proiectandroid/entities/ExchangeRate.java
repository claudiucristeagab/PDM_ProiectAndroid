package com.example.pdm_proiectandroid.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExchangeRate {
    @SerializedName("rates")
    private HashMap<String, Double> rates;
    @SerializedName("date")
    private Date date;
    @SerializedName("base")
    private String Base;

    public ExchangeRate(){
        rates = new HashMap<>();
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "rates=" + rates +
                ", date=" + date +
                ", Base='" + Base + '\'' +
                '}';
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }
}
