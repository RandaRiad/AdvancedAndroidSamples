package com.randa.myfirstapplication.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper
{


    private  static  final String  DB_NAME="courses";
    private static final  int DB_VERSION=1;
    private  static  final String  TABLE_NAME="mycourses";
    private static final String ID_COL="id";
    private static final String NAME_COL="NAME";



    public MyDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+TABLE_NAME+ "(" +ID_COL+ "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +NAME_COL+"TEXT)";

        db.execSQL(query );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // this method if you want to change database of version to edit in your table
        // you have to change version and add the code to upgrade  database
    }
}
