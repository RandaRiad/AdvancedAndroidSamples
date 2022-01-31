package com.randa.myfirstapplication.HandlerNew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.randa.myfirstapplication.R;

import java.util.ArrayList;

public class HandlerActivity extends AppCompatActivity {

    TextView text;
    Button button;
    ArrayList<String> names= new ArrayList<>();
    MyHandler handler=new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        text=findViewById(R.id.handler_text);
        button=findViewById(R.id.handler_button);
        names.add("Randa");
        names.add("David");
        names.add("Julia");
        names.add("Eliana");

      button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Thread(new ThreadArray()).start();
            }
        });


    }

   class ThreadArray implements Runnable {
        @Override
        public void run() {
           /* for(String name :names){
                text.post(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        text.setText(name);
                    }
                });

            }

            */
           /* for(String name:names){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(name);
                    }
                });
            }
            */

          /*  for(String name:names){


                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        text.setText(name);
                    }
                });
            }

           */


                Message message=new Message();
                message.obj=names;
                handler.sendMessage(message);


        }
    }




    class MyHandler extends Handler {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            ArrayList<String> list= (ArrayList<String>) msg.obj;
            if(list!=null){
                for(String name :list){
                    text.setText(name);
                }
            }



        }
    }
}

