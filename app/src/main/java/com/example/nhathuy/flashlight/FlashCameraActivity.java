package com.example.nhathuy.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class FlashCameraActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton tgbFlash;
    Camera camera;
    Camera.Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flashcamera);

        tgbFlash = (ToggleButton) findViewById(R.id.tgbFlashCamera);

        camera = Camera.open();
        parameters = camera.getParameters();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            moFlashCamera();
        } else {
            tatFlashCamera();
        }
    }

    private void moFlashCamera() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void tatFlashCamera() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.startPreview();
    }
}
