package com.randa.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {

    TextView name,email,password, text1;
    Button signUpButton, button1;
    String nameString ,emailString , passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* name=findViewById(R.id.nameText);
        email=findViewById(R.id.emailText);
        password=findViewById(R.id.passwordText);
        signUpButton=findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
*/


        text1=findViewById(R.id.text1);
        button1=findViewById(R.id.button1);


        MaterialDatePicker datePicker=MaterialDatePicker.Builder.dateRangePicker().
                setTitleText("select Date").
                setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(),MaterialDatePicker.todayInUtcMilliseconds())).
                build();

         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 datePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER");
                 datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                     @Override
                     public void onPositiveButtonClick(Object selection) {
                         text1.setText(datePicker.getHeaderText());
                     }
                 });
             }
         });



    }

    public void register(){
        nameString=name.getText().toString();
        emailString=email.getText().toString();
        passwordString=password.getText().toString();

        if(nameString.isEmpty()){
            name.setError("Please, Enter Your Name");
            name.requestFocus();
            return;

        }else if (emailString.isEmpty()){
            email.setError(" Please, Enter Your Email ");
            email.requestFocus();
            return;

        }else if(passwordString.isEmpty() || passwordString.length()<4){
            password.setError("Please, Enter Your Password or Password must be 5 or more .. ");
            password.requestFocus();
            return;

        }else if (nameString.isEmpty() &&
                emailString.isEmpty() &&
                (passwordString.isEmpty() || passwordString.length()<4) ){

            Toast.makeText(this, " Fields are Empty", Toast.LENGTH_SHORT).show();
            name.requestFocus();
            return;

        }else if ( ! (nameString.isEmpty() &&
                emailString.isEmpty() &&
                (passwordString.isEmpty() || passwordString.length()<4)) ){

           Toast.makeText(this,"User has been register.. ", Toast.LENGTH_LONG).show();
           startActivity( new Intent(MainActivity.this, Home.class));

        }


    }
}