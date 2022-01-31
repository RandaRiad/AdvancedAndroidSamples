package com.randa.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferrence extends AppCompatActivity {

    EditText email, password;
    Button save, restore;
    String emailSaved, passwordSaved;

    SharedPreferences shared;
    SharedPreferences.Editor edit;
    final static String USER_KEY="userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferrence);

        email=findViewById(R.id.email_save);

        password=findViewById(R.id.password_save);

        save=findViewById(R.id.button_save);
        restore=findViewById(R.id.button_restore);

        // create default file
       // shared = PreferenceManager.getDefaultSharedPreferences(this);
        
        // create file with specific name
       shared = getSharedPreferences("file", MODE_PRIVATE);

        edit= shared.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailSaved=email.getText().toString();
                passwordSaved=password.getText().toString();

                edit.putString("email",emailSaved );
                edit.putString("password",passwordSaved);
                edit.apply();

                Toast.makeText(SharedPreferrence.this,emailSaved+" | "+ passwordSaved, Toast.LENGTH_LONG).show();

            }
        });


        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  emai= shared.getString("email","No Email");
                String  pass= shared.getString("password","No password");

                Toast.makeText(SharedPreferrence.this,emai+" | "+ pass, Toast.LENGTH_LONG).show();

            }
        });

    }
}