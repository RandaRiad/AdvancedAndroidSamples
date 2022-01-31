package com.randa.myfirstapplication.Notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.randa.myfirstapplication.R;
import com.randa.myfirstapplication.databinding.ActivityNoteBinding;

public class Note extends AppCompatActivity {

    ActivityNoteBinding binding;

    private String channelID="firstNotification";
    private String channelName="My First Notification";
    private String channelDescription="Notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    public void displayNotification() {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Intent intent=new Intent(this,Note.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelID);
        builder.setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Hello")
                .setContentText("randa speaking now")
                .setStyle(new NotificationCompat.BigTextStyle())
                .addAction(R.drawable.ic_baseline_person_24,"Reply",pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        int notificationID=12;
        NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);
        managerCompat.notify(notificationID,builder.build());

    }
}