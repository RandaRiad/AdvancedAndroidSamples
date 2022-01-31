package com.randa.myfirstapplication.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, exportSchema = false, version = 1)
public  abstract class EmployeeDataBase  extends RoomDatabase {

    private  static final  String DB_NAME="company_db";
    private  static  EmployeeDataBase instance;

    public static synchronized EmployeeDataBase getInstance(Context context){

        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), EmployeeDataBase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

    public abstract EmployeeDao employeeDao();

}
