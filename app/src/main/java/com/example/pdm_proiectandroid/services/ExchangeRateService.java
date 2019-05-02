package com.example.pdm_proiectandroid.services;

import com.example.pdm_proiectandroid.ApiStrings;
import com.example.pdm_proiectandroid.entities.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class ExchangeRateService {

    public ExchangeRateService(){

    }

    public ExchangeRate getTodayRates(String currencyName) throws IOException {
        String apiUrl = ApiStrings.Latest + currencyName;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + apiUrl);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        ExchangeRate exchangeRate = new ExchangeRate();
        return exchangeRate;
    }

    public ExchangeRate getRatesForDate(String currencyName, Date dateTime) throws IOException {
        String apiUrl = ApiStrings.Latest + dateTime.toString() + "?base=" + currencyName;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + apiUrl);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        ExchangeRate exchangeRate = new ExchangeRate();
        return exchangeRate;
    }
}
