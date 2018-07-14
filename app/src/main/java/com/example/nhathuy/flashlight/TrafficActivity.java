package com.example.nhathuy.flashlight;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficActivity extends AppCompatActivity {
    ImageView imgTraffic;

    Timer timer;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_traffic);

        imgTraffic = (ImageView) findViewById(R.id.imgTraffic);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                LevelListDrawable levelListDrawable = (LevelListDrawable) imgTraffic.getDrawable();
                int currentLevel = levelListDrawable.getLevel();

                if(currentLevel < 2) {
                    currentLevel++;
                } else {
                    currentLevel = 0;
                }

                imgTraffic.setImageLevel(currentLevel);
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
}
