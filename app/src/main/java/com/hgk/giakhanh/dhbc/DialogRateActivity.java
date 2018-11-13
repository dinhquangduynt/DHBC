package com.hgk.giakhanh.dhbc;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class DialogRateActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnSubmit, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_rate);

        AnhXa();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // App.finishApp(DialogRateActivity.this);
            }
        });
    }

    private void AnhXa() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        btnSubmit = (Button) findViewById(R.id.submit_btn);
        btnHuy = (Button) findViewById(R.id.huy_btn);
    }
}
