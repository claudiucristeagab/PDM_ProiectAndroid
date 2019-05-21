package com.example.pdm_proiectandroid;

import android.net.Uri;
import android.provider.BaseColumns;

public class CurrencyContract implements BaseColumns {
    public static final String TABLE_NAME = "Currencies";
    public static final String ID = "Id";
    public static final String NAME = "Name";

    public static final String[] PROJECTION = new String[] {
        CurrencyContract.ID,
        CurrencyContract.NAME
    };

    public static final Uri URI = Uri.parse("content://com.example.pdm_proiectandroid.PROVIDER");
}
