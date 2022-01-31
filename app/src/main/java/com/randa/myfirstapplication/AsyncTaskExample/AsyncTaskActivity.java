package com.randa.myfirstapplication.AsyncTaskExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.randa.myfirstapplication.R;

public class AsyncTaskActivity extends AppCompatActivity {
 Button button;
 ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        button=findViewById(R.id.asunc_btn);
        imageView=findViewById(R.id.async_imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task=new MyTask();
                task.execute();
            }
        });
    }


    class MyTask extends AsyncTask<String, Integer, Void>{
        @Override
        protected Void doInBackground(String... strings) {

            imageView.setImageDrawable(getResources().getDrawable(R.drawable.tree));

            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imageView.setVisibility(View.VISIBLE);
            Toast.makeText(AsyncTaskActivity.this,"preExecute",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            imageView.setVisibility(View.VISIBLE);
            Toast.makeText(AsyncTaskActivity.this,"PostExecute",Toast.LENGTH_LONG).show();


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imageView.setVisibility(View.VISIBLE);
            Toast.makeText(AsyncTaskActivity.this,"on preogess",Toast.LENGTH_LONG).show();


        }
    }
}