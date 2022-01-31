package com.randa.myfirstapplication.ExternalDataBase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.randa.myfirstapplication.R;

import java.util.ArrayList;

public class DatabaseLogin extends AppCompatActivity {

    EditText name;
    Button save, update,delete;
    String nameLogin;
    Person person;
    DataBaseAccess data;

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_login);

        name=findViewById(R.id.name_login);
        save=findViewById(R.id.save_button);
        update=findViewById(R.id.update_button);
        list=findViewById(R.id.list_view);
        delete=findViewById(R.id.delete_button);
        //MyDataBasePerson data=MyDataBasePerson.getInstance(this);

        data=DataBaseAccess.getInstance(this);

        data.open();
        ArrayList<Person> names=data.getPerson();
        ArrayList<String> nam=new ArrayList<>();
        for(Person p:names){
            //nam.add(String.valueOf(p.getId()));
            nam.add(p.getName());
        }
        data.close();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nam);
        list.setAdapter(adapter);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.open();
                nameLogin=name.getText().toString();
                person=new Person(nameLogin);
             if(data.insertPerson(person)){
                 Toast.makeText(DatabaseLogin.this, "Sucssful",Toast.LENGTH_LONG).show();

             } else{
                 Toast.makeText(DatabaseLogin.this, "error",Toast.LENGTH_LONG).show();

             }
             data.close();
            }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.open();
                person=new Person("randa2",20);
                if(data.updatePerson(person)){
                    Toast.makeText(DatabaseLogin.this, "Sucssful",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(DatabaseLogin.this, "error",Toast.LENGTH_LONG).show();

                }
                data.close();
            }


        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.open();
               person=new Person("tttt",1);
                if(data.deletePerson(person)){
                    Toast.makeText(DatabaseLogin.this, "Sucssful",Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(DatabaseLogin.this, "error",Toast.LENGTH_LONG).show();

                }
                data.close();
            }


        });


    }
}