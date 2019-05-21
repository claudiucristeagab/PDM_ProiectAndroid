package com.example.pdm_proiectandroid.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.pdm_proiectandroid.CurrencyContract;
import com.example.pdm_proiectandroid.storage.DatabaseHelper;

public class CurrencyContentProvider extends ContentProvider {

    private DatabaseHelper databaseHelper;
    @Override
    public boolean onCreate() {

        this.databaseHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(CurrencyContract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        //db.close();
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long value = db.insert(CurrencyContract.TABLE_NAME, null, values);
        //db.close();
        return Uri.withAppendedPath(CurrencyContract.URI, String.valueOf(value));
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        int i = db.delete(CurrencyContract.TABLE_NAME, selection, selectionArgs);
        //db.close();
        return i;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
