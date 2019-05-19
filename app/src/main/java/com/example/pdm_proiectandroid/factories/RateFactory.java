package com.example.pdm_proiectandroid.factories;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.pdm_proiectandroid.ApiStrings;
import com.example.pdm_proiectandroid.entities.ExchangeRate;
import com.example.pdm_proiectandroid.entities.Rate;
import com.example.pdm_proiectandroid.services.ExchangeRateService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.pdm_proiectandroid.MainActivity.SelectedCurrency;

public class RateFactory implements RemoteViewsService.RemoteViewsFactory {

    private List<Rate> rates;
    private ExchangeRateService exchangeRateService;
    private Context context;

    public RateFactory(Context context) {
        this.context = context;
        this.exchangeRateService = new ExchangeRateService();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        ExchangeRate exchangeRate = getTodayRates();
        this.rates = exchangeRateService.hashToList(exchangeRate);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return rates.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), android.R.layout.simple_list_item_1);
        Rate rate = rates.get(position);
        remoteViews.setTextViewText(android.R.id.text1, rate.getName() + ": " + rate.getValue() + " " + SelectedCurrency.getName());
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private ExchangeRate getTodayRates(){
        ExchangeRate exchangeRate = new ExchangeRate();

        String currencyName = SelectedCurrency.getName();

        if(currencyName == null || currencyName.equals(""))
        {
            currencyName = ApiStrings.DefaultCurrency;
        }
        try {
            exchangeRate = exchangeRateService.getTodayRates(currencyName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}
