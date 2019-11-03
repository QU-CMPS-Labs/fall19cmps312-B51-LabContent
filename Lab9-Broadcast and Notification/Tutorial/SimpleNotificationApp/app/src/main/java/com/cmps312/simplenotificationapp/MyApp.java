package com.cmps312.simplenotificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.ArrayList;

public class MyApp extends Application {

    public static final String MAIN_CHANNEL = "main_channel";
    public static final String SECONDARY_CHANNEL = "secondary_channel";

    @Override
    public void onCreate() {
        super.onCreate();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel mainChannel = new NotificationChannel(MAIN_CHANNEL,
                    "Main Channel" ,
                    NotificationManager.IMPORTANCE_HIGH);

            mainChannel.setDescription("This is the main channel of our " +
                    "notification and it is responsible for .....");


            NotificationChannel secondaryChannel = new NotificationChannel(SECONDARY_CHANNEL,
                    "Secondary Channel" ,
                    NotificationManager.IMPORTANCE_LOW);

            secondaryChannel.setDescription("This is the secondary channel of our " +
                    "notification and it is responsible for .....");

            ArrayList<NotificationChannel> channels = new ArrayList<>();
            channels.add(mainChannel);
            channels.add(secondaryChannel);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannels(channels);
        }

    }


}
