package com.example.sqliteasync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Shameeddp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shainfo.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE = " CREATE TABLE " + ShaContract.shaCont.TABLE_NAME + "(" + ShaContract.shaCont.ID + " INTEGER," + ShaContract.shaCont.NAME + " TEXT," +
            ShaContract.shaCont.DEPARTMENT + " TEXT);";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + ShaContract.shaCont.TABLE_NAME;

    Shameeddp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);

        Log.d("Database Operation", "Table Droped");
    }

    public void addContacts(int id, String name, String dept, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShaContract.shaCont.ID, id);
        contentValues.put(ShaContract.shaCont.NAME, name);
        contentValues.put(ShaContract.shaCont.DEPARTMENT, dept);
        database.insert(ShaContract.shaCont.TABLE_NAME, null, contentValues);
    }

    public Cursor readContacts(SQLiteDatabase database) {
        String[] projection = {ShaContract.shaCont.ID, ShaContract.shaCont.NAME, ShaContract.shaCont.DEPARTMENT};
        Cursor cursor = database.query(ShaContract.shaCont.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
