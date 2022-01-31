package com.randa.myfirstapplication.ViewBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.randa.myfirstapplication.R;
import com.randa.myfirstapplication.databinding.ActivityBindTestBinding;

public class BindTest extends AppCompatActivity {

    ActivityBindTestBinding bindTestBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindTestBinding=ActivityBindTestBinding.inflate(getLayoutInflater());
        setContentView(bindTestBinding.getRoot());


        bindTestBinding.buttonBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bindTestBinding.textViewBinding.setText("Randa");
    }
}