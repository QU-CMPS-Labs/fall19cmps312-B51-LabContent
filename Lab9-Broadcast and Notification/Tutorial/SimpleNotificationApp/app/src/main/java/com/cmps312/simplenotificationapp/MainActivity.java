package com.cmps312.simplenotificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.cmps312.simplenotificationapp.MyApp.MAIN_CHANNEL;
import static com.cmps312.simplenotificationapp.MyApp.SECONDARY_CHANNEL;

public class MainActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    EditText bodyTextEdt;
    EditText titleTextEdt;
    int mainChannelCounter =0;
    int secondaryChannelCounter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        bodyTextEdt = findViewById(R.id.body_edt);
        titleTextEdt = findViewById(R.id.title_edt);
    }

    public void postSecondaryChannel(View view) {

        Notification notification = new NotificationCompat
                .Builder(this, SECONDARY_CHANNEL)
                .setSmallIcon(R.drawable.secondary_channel_icon)
                .setContentTitle(titleTextEdt.getText())
                .setContentText(bodyTextEdt.getText())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true)
                .build();

        notificationManagerCompat.notify(secondaryChannelCounter++, notification);
    }

    public void postMainChannel(View view) {
        //to create an intent
        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //create pending intent

        Notification notification = new NotificationCompat
                .Builder(this, MAIN_CHANNEL)
                .setSmallIcon(R.drawable.main_channel_icon)
                .setContentTitle(titleTextEdt.getText())
                .setContentText(bodyTextEdt.getText())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        notificationManagerCompat.notify(mainChannelCounter++, notification);
    }
}















