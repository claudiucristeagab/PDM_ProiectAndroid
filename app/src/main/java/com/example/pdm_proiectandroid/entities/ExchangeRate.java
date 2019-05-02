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
}
