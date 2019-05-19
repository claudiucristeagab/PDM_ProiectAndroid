package com.example.pdm_proiectandroid.services;

import android.content.Intent;
import android.widget.RemoteViewsService;

import com.example.pdm_proiectandroid.factories.RateFactory;

public class RateWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RateFactory(getApplicationContext());
    }
}
