package com.example.pdm_proiectandroid.services;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.pdm_proiectandroid.CurrencyContract;
import com.example.pdm_proiectandroid.entities.Currency;
import com.example.pdm_proiectandroid.providers.CurrencyContentProvider;

import java.util.ArrayList;
import java.util.List;

public class FavoritesService {

    private ContentResolver contentResolver;
    private Uri uri;

    public FavoritesService(Context context){
        contentResolver = context.getContentResolver();
        uri = CurrencyContract.URI;
    }

    public List<Currency> getAll(){
        List<Currency> list = new ArrayList<>();

        Cursor cursor = contentResolver.query(uri,null, null, null,null);

        while(cursor.moveToNext()){
            Currency currency = new Currency();
            currency.setId(cursor.getInt(0));
            currency.setName(cursor.getString(1));
            list.add(currency);
        }

        return list;
    }

    public void addCurrency(Currency currency){
        ContentValues values = new ContentValues();
        values.put(CurrencyContract.NAME, currency.getName());
        contentResolver.insert(uri,values);
    }

    public int delete(Currency currency, String where, String[] a){
        return contentResolver.delete(uri, where, a);
    }
}
