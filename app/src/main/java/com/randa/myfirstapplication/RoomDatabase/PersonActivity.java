package com.randa.myfirstapplication.RoomDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.randa.myfirstapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

Button save, update, delete;
EditText nameSave, addressSave, nameUpdate, idUpdate, idDelete;
PersonDataBase personDataBase;
ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        save=findViewById(R.id.button_person_save);
        delete=findViewById(R.id.button_delete);
        update=findViewById(R.id.button_update);

        nameSave=findViewById(R.id.personNameSave);
        addressSave=findViewById(R.id.personAddressSave);
        nameUpdate=findViewById(R.id.name_person_update);
        idUpdate=findViewById(R.id.id_person_update);
        idDelete=findViewById(R.id.id_person_delete);

        list=findViewById(R.id.person_list);

        personDataBase=PersonDataBase.getInstance(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personDataBase.personDao().insertPerson( new Person(nameSave.getText().toString(),
                        addressSave.getText().toString()));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personDataBase.personDao().deletePerson(new Person( Integer.parseInt(idDelete.getText().toString())));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personDataBase.personDao().updatePerson(nameUpdate.getText().toString(),Integer.parseInt(idUpdate.getText().toString()) );
            }
        });


        // select all persons
        personDataBase.personDao().getPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                if(people==null){
                    Toast.makeText(PersonActivity.this, " No Data", Toast.LENGTH_LONG).show();
                }
                else{
                    ArrayList<String> personNames =new ArrayList<>();
                    for(Person person : people){
                        personNames.add(person.getId() +" : "+person.getName());
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(PersonActivity.this,
                            android.R.layout.simple_list_item_1,personNames);
                    list.setAdapter(adapter);
                }
            }
        });

    }
}