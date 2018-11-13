package com.hgk.giakhanh.dhbc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Random;

public class SettingsActivity extends AppCompatActivity {
    ImageView imgAmKich;
    SeekBar skbAmKich, skbNhac;
    ArrayList<Integer> arrayBackGround1;
    RelativeLayout relBackgroundSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        AnhXa();
    }

    private void AnhXa(){
        imgAmKich = (ImageView) findViewById(R.id.imageViewAmKich);
        relBackgroundSettings = (RelativeLayout) findViewById(R.id.relativeLayoutBackGroundSettings);
        skbAmKich = (SeekBar) findViewById(R.id.seekBarAmKich);
        skbNhac = (SeekBar) findViewById(R.id.seekBarNhac);
    }
}
