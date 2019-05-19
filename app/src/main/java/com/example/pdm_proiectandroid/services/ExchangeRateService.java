package com.example.pdm_proiectandroid.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdm_proiectandroid.ApiStrings;
import com.example.pdm_proiectandroid.entities.ExchangeRate;
import com.example.pdm_proiectandroid.entities.Rate;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExchangeRateService {

    private OkHttpClient httpClient;
    private Gson jsonParser;

    public ExchangeRateService() {
        httpClient = new OkHttpClient();
        jsonParser = new Gson();
    }

    public ExchangeRate getTodayRates(String currencyName) throws IOException {
        String apiUrl = ApiStrings.Latest + currencyName;

        ExchangeRate exchangeRate;
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String json = response.body().string();
            Log.e("API", json);
            exchangeRate = jsonParser.fromJson(json, ExchangeRate.class);
            Log.e("ExchangeRate", exchangeRate.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            exchangeRate = new ExchangeRate();
        }
        return exchangeRate;
    }

    public ExchangeRate getRatesForDate(String currencyName, Date dateTime) throws IOException {
        String apiUrl = ApiStrings.Latest + dateTime.toString() + "?base=" + currencyName;

        ExchangeRate exchangeRate;
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String json = response.body().string();
            Log.e("API", json);
            exchangeRate = jsonParser.fromJson(json, ExchangeRate.class);
            Log.e("ExchangeRate", exchangeRate.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            exchangeRate = new ExchangeRate();
        }
        return exchangeRate;
    }

    public ArrayList<Rate> hashToList(ExchangeRate exchangeRate) {
        int nrOfRates = exchangeRate.getRates().size();
        ArrayList<Rate> list = new ArrayList<>();

        ArrayList<String> names = new ArrayList(exchangeRate.getRates().keySet());
        ArrayList<Double> values = new ArrayList(exchangeRate.getRates().values());

        for(int i = 0; i<nrOfRates; i++) {
            Rate rate = new Rate();
            rate.setName(names.get(i));
            rate.setValue(values.get(i));
            list.add(rate);
        }

        return list;
    }
}
