package com.randa.myfirstapplication.ExternalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseAccess {

    private static final String ID_COL="id";
    private static final String NAME_COL="name";
    private static final String TABLE_NAME="employee";

    private  static DataBaseAccess instance;
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;

    private DataBaseAccess(Context context) {
        this.openHelper = new MyDataBasePerson(context);
    }

    //singleton for the database to prevent any one use this class
    public static DataBaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DataBaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database=openHelper.getWritableDatabase();
    }

    public void close(){
        if(database!=null){
            this.database.close();
        }
    }
    // insert method

    public boolean insertPerson(Person person){

        ContentValues values=new ContentValues();
        values.put(NAME_COL, person.getName());
        long newRow=database.insert(TABLE_NAME, null, values);

        return newRow!= -1;

    }

    // update method


    public boolean updatePerson(Person person){


        ContentValues values=new ContentValues();
        values.put(NAME_COL, person.getName());

        String[] args={String.valueOf(person.getId())};

        int result=database.update(TABLE_NAME,values,ID_COL+"=?",args);
        return result > 0;
    }

    // delete method

    public boolean deletePerson (Person person){

      //  database=openHelper.getWritableDatabase();

        String[] args={person.getId()+""};

       // int result=database.delete(TABLE_NAME,"id=?",args);
        int result=database.delete(TABLE_NAME,null,null);

        return result > 0;
    }

    // select method

    public ArrayList<Person> getPerson(){

        ArrayList<Person> person =new ArrayList<>();

        Cursor cursor=database.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        if(cursor.moveToFirst() && cursor!=null){
            do{

                int id =cursor.getInt(cursor.getColumnIndex(ID_COL));
                String name= cursor.getString(cursor.getColumnIndex(NAME_COL));
                Person person1= new Person(name, id);
                person.add(person1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return person;
    }

}


