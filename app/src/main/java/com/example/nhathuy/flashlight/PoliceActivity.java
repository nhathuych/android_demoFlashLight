package com.example.nhathuy.flashlight;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class PoliceActivity extends AppCompatActivity {
    ToggleButton tgbPolice;

    Timer timer;
    Handler handler;
    boolean check = false;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_police);

        tgbPolice = (ToggleButton) findViewById(R.id.tgbPolice);

        player = MediaPlayer.create(PoliceActivity.this, R.raw.music_police);
        player.setLooping(true);    // cho lặp nhiều lần
        player.start();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(!check) {
                    check = true;
                } else {
                    check = false;
                }
                tgbPolice.setChecked(check);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }
}
