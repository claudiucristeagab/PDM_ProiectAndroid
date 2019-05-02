package com.example.pdm_proiectandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Rate {
    @SerializedName("key")
    private String name;
    @SerializedName("value")
    private double value;

    public Rate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
