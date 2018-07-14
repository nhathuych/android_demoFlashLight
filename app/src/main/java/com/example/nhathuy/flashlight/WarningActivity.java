package com.example.nhathuy.flashlight;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class WarningActivity extends AppCompatActivity {
    ToggleButton tgbWarning;

    Handler handler;
    Timer timer;

    boolean checkWarning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_warning);

        tgbWarning = (ToggleButton) findViewById(R.id.tgbWarning);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(!checkWarning) {
                    checkWarning = true;
                } else {
                    checkWarning = false;
                }
                tgbWarning.setChecked(checkWarning);
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
