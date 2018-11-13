package com.hgk.giakhanh.dhbc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnChoiMoi, btnTiepTuc, btnDiemCao;
    ImageButton imbRate, imbShare, imbSettings, imbExit;
    RelativeLayout relBackground;
    ListView lsvShare;
    ArrayList<Integer> arrayBackGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        AnhXa();
        //button settings

        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.church);
        imbSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
                //startActivity(intent1);
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imbSettings.setImageResource(R.drawable.pause);
                } else {
                    mediaPlayer.start();
                    imbSettings.setImageResource(R.drawable.settings);
                }
            }
        });


//        imbSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(intent1);
//            }
//        });

        //button chơi ngay

        btnChoiMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, TopicActivity.class);
                startActivity(intent2);
            }
        });

        //button diem cao
        btnDiemCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, HighscoresActivity.class);
                startActivity(intent2);
            }
        });

        //button exit

        imbExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Thoát??");
                b.setMessage("Bạn có thật sự muốn thoát??");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.pause();
                        App.finishApp(MainActivity.this);
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                b.create().show();
            }
        });

        //button share
        imbShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialogShare();
            }
        });

        imbRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialogRate();
            }
        });

    }

    private void OpenDialogShare(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog_share);
        dialog.setTitle("Share để bạn bè cùng chơi");
        dialog.show();
    }

    private void OpenDialogRate() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog_rate);
        dialog.show();
    }

    private void AnhXa(){
        btnChoiMoi = (Button) findViewById(R.id.buttonChoiMoi);
        btnTiepTuc = (Button) findViewById(R.id.buttonTiepTuc);
        btnDiemCao = (Button) findViewById(R.id.buttonDiemCao);

        imbExit = (ImageButton) findViewById(R.id.imageButtonExit);
        imbSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        imbShare = (ImageButton) findViewById(R.id.imageButtonShare);
        imbRate = (ImageButton) findViewById(R.id.imageButtonRate);

        relBackground = (RelativeLayout) findViewById(R.id.relativeLayoutBackGround);
    }
}
