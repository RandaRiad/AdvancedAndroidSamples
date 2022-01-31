package com.randa.myfirstapplication.Thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.randa.myfirstapplication.R;

import java.util.ArrayList;

public class ThreadTest extends AppCompatActivity {

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);

        btn=findViewById(R.id.thread_btn);
        textView=findViewById(R.id.thread_text);
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread( new Task()).start();
               /* runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        new Thread( new ThreadExcute()).start();
                       // Bundle bb= new Bundle();
                        //ArrayList<Integer > list =bb.getIntegerArrayList("i");

                      /*  for(Integer  i: list){
                            try {
                                textView.setText(i+"");
                                Log.d("randa",i+"");
                                Thread.sleep(1000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                });

                */

            }

        });


    }

    class Task implements Runnable{

        int i=0;
        @Override
        public void run() {


               textView.post(new Runnable() {
                   @Override
                   public void run() {
                       for ( i=0;i<10; i++){
                      textView.setText(i+"");

                   }}
               });


        }
    }
}