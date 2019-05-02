package com.example.pdm_proiectandroid.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExchangeRate {
    @SerializedName("rates")
    private List<Rate> rates;
    @SerializedName("date")
    private Date date;
    @SerializedName("base")
    private String Base;

    public ExchangeRate(){
        rates = new ArrayList<>();
    }
}
