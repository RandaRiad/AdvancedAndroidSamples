package com.randa.myfirstapplication.ExternalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDataBasePerson extends SQLiteAssetHelper {

    private static final String DB_NAME = "person.db";
    private static final int VERSION = 1;


    public MyDataBasePerson(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

}