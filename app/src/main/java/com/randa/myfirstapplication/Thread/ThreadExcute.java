package com.randa.myfirstapplication.Thread;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreadExcute implements Runnable {

    Bundle bundle=new Bundle();
    ArrayList<Integer > list=new ArrayList();
    @Override
    public void run() {

       for (int i=0;i<10; i++){

           list.add(i);


        }
        bundle.putIntegerArrayList("i", list);





    }






}
