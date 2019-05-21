package com.example.pdm_proiectandroid.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pdm_proiectandroid.CurrencyContract;
import com.example.pdm_proiectandroid.entities.Currency;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EXCHANGE_DB";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCurrencyTable = "CREATE TABLE Currencies ( " +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT)";
        db.execSQL(createCurrencyTable);
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CurrencyContract.TABLE_NAME);

        this.onCreate(db);
    }

    // Select
    public List<Currency> getAllCurrencies(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(CurrencyContract.TABLE_NAME, CurrencyContract.PROJECTION,
                        null, null,
                        null,null,
                        null,null);

        List<Currency> list = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Currency currency = new Currency();
                currency.setId(cursor.getInt(0));
                currency.setName(cursor.getString(1));
                list.add(currency);
            } while (cursor.moveToNext());
        }

        return list;
    }

    // Insert
    public void addCurrency(Currency currency){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CurrencyContract.NAME, currency.getName());

        db.insert(CurrencyContract.TABLE_NAME, null, values);

        //db.close();
    }

    // Delete
    public void deleteCurrency(Currency currency){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CurrencyContract.TABLE_NAME, CurrencyContract.ID + "=?", new String[] {String.valueOf(currency.getId())});
        //db.close();
    }
}
