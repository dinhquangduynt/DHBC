package com.hgk.giakhanh.dhbc;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DialogShareActivity extends AppCompatActivity {
    //ListView lsvShare;
    Button btnFacebook, btnZalo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_share);
        AnhXa();



    }
    private void AnhXa() {
        btnFacebook = (Button) findViewById(R.id.buttonFacebook);
        btnZalo = (Button) findViewById(R.id.buttonZalo);
    }

}
