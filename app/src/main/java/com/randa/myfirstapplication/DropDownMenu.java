package com.randa.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class DropDownMenu extends AppCompatActivity {


    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);


        textInputLayout=findViewById(R.id.menu_drop);
        autoCompleteTextView =findViewById(R.id.drop_items);
        textView=findViewById(R.id.itemSelected);

        String [] items={"Item1", "Item2","Item3","Item4","Item5","Other"};
        ArrayAdapter<String> itemAdapter=new ArrayAdapter<>(DropDownMenu.this , R.layout.items_list, items);
        autoCompleteTextView.setAdapter(itemAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText( (String)parent.getItemAtPosition(position));
            }
        });




    }
}