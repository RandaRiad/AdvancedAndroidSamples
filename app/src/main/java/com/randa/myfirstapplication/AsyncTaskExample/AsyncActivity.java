package com.randa.myfirstapplication.AsyncTaskExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.randa.myfirstapplication.R;

public class AsyncActivity extends AppCompatActivity {

    EditText stringName;
    TextView  count;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        stringName=findViewById(R.id.text_async);
        count=findViewById(R.id.number_async);
        button=findViewById(R.id.count_async_buuton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTaskExample taskExample=new MyTaskExample();
                taskExample.execute(stringName.getText().toString());//send to indobackground
            }
        });
    }


    class MyTaskExample extends AsyncTask<String , String, Boolean >{

        String sub=null;
        @Override
        protected Boolean doInBackground(String... strings) {
            if(strings!=null){
                String sub= strings[0].substring(4);
                publishProgress(sub);
                return true;
            }
            else

          return false;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            if(values==null){
                Toast.makeText(AsyncActivity.this,"Not",Toast.LENGTH_LONG).show();

            }else{
                count.setText(values[0]);

            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                Toast.makeText(AsyncActivity.this,"Done",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(AsyncActivity.this,"Not string",Toast.LENGTH_LONG).show();


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            count.setVisibility(View.VISIBLE);
        }
    }
}