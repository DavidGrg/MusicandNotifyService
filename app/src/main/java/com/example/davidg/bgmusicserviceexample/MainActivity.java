package com.example.davidg.bgmusicserviceexample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start, stop, notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        start = (Button) findViewById( R.id.btnStart );
        start.setOnClickListener( this );

        stop = (Button) findViewById( R.id.btnStop );
        stop.setOnClickListener( this );

        notify = (Button) findViewById( R.id.btnNotify );
        notify.setOnClickListener( this );




    }


    //N/B: don't forget to declare service in the manifest.

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnStart:
                startService( new Intent( this, MusicService.class ) );
                break;

            case R.id.btnStop:
                stopService( new Intent( this, MusicService.class ) );
                break;

            case R.id.btnNotify:
                startService( new Intent( this, NotificationService.class ) );



        }
    }
}
