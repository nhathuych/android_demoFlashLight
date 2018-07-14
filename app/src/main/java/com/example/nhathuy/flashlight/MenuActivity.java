package com.example.nhathuy.flashlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnLight, btnNeon, btnWarning, btnTraffic, btnPolice, btnFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        btnLight = (ImageButton) findViewById(R.id.btnLight);
        btnNeon = (ImageButton) findViewById(R.id.btnNeon);
        btnWarning = (ImageButton) findViewById(R.id.btnWarning);
        btnTraffic = (ImageButton) findViewById(R.id.btnTraffic);
        btnPolice = (ImageButton) findViewById(R.id.btnPolice);
        btnFlash = (ImageButton) findViewById(R.id.btnFlashLight);

        btnLight.setOnClickListener(this);
        btnNeon.setOnClickListener(this);
        btnWarning.setOnClickListener(this);
        btnTraffic.setOnClickListener(this);
        btnPolice.setOnClickListener(this);
        btnFlash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLight:
                startActivity(new Intent(MenuActivity.this, LightActivity.class));
                break;
            case R.id.btnNeon:
                startActivity(new Intent(MenuActivity.this, NeonActivity.class));
                break;
            case R.id.btnWarning:
                startActivity(new Intent(MenuActivity.this, WarningActivity.class));
                break;
            case R.id.btnTraffic:
                startActivity(new Intent(MenuActivity.this, TrafficActivity.class));
                break;
            case R.id.btnPolice:
                startActivity(new Intent(MenuActivity.this, PoliceActivity.class));
                break;
            case R.id.btnFlashLight:
                startActivity(new Intent(MenuActivity.this, FlashCameraActivity.class));
                break;
        }
    }
}
