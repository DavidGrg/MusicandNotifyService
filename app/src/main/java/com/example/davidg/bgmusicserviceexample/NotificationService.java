package com.example.davidg.bgmusicserviceexample;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Handler;

/**
 * Created by DavidG on 05/03/2018.
 */

public class NotificationService extends IntentService {

    private final String TAG = "NotificationService";
    public static final int NOTIFICATION_ID = 9;

//    private Handler handler;

    public NotificationService() {
        super( "NotifcationService" );
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        createnotification();
        return super.onStartCommand( intent, flags, startId );
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.v(TAG, "Message to be printed.");
        if (intent!=null){
            synchronized(this){
                try {
                    wait(1000);


                }catch (InterruptedException E){
                    E.printStackTrace();
                }
                Log.v( TAG, "Service " );


                Toast.makeText( getApplicationContext(), "Service Completed", Toast.LENGTH_SHORT ).show();




            }
        }

    }


    public void createnotification(){

        Intent in = new Intent( this, MainActivity.class );  // defines the activity that will be shown when the notification is pressed.
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, in, 0);


        Notification notification = new Notification.Builder(this)
                        .setContentTitle("Helloo")
                        .setContentText("How You doing?!!;)")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentIntent(pendingIntent)
                        .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);









    }


}
