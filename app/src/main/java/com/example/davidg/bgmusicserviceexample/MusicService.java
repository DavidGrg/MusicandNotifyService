package com.example.davidg.bgmusicserviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

/**
 * Created by DavidG on 05/03/2018.
 */

public class MusicService extends Service {

    private MediaPlayer player;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI ); // create music player object that plays default alarm sound.
        player.setLooping( true );  ///it will keep the above music on the loop.
        player.start();
        return START_STICKY; // THIS SERVICE WILL START WITHOUT THE MAIN ACTIVITY
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();

    }
}
