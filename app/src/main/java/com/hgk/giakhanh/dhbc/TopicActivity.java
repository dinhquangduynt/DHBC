package com.hgk.giakhanh.dhbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class TopicActivity extends AppCompatActivity {
    Button btnAnh, btnViet;
    EditText edtName;
    RelativeLayout relBackGroundTopic;
    ArrayList<Integer> arrayBackGroundTopic;
    boolean check = true;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        //ánh xạ
        AnhXa();

        //buttonTiengViet
        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = XuLyEditText();
                if(check == true){
                    Intent intent = new Intent(TopicActivity.this, PlayActivity.class);
                    intent.putExtra("NgonNgu", 2);
                    intent.putExtra("TenNguoiChoi", edtName.getText().toString());
                    startActivity(intent);
                }
            }
        });

        //buttonAnh
        btnViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = XuLyEditText();
                if(check == true){
                    Intent intent = new Intent(TopicActivity.this, PlayActivity.class);
                    intent.putExtra("NgonNgu", 1);
                    intent.putExtra("TenNguoiChoi", edtName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private void AnhXa(){
        btnAnh = (Button) findViewById(R.id.buttonTiengAnh);
        btnViet = (Button) findViewById(R.id.buttonTiengViet);
        edtName = (EditText) findViewById(R.id.editTextName);
        relBackGroundTopic = (RelativeLayout) findViewById(R.id.relativeLayoutBackGroundTopic);
    }

    private boolean XuLyEditText(){
        String temp = edtName.getText().toString();
        if(temp.length()==0){
            Toast.makeText(TopicActivity.this, "Nhập tên của bạn!!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
