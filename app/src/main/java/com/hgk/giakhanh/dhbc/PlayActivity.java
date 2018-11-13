package com.hgk.giakhanh.dhbc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hgk.giakhanh.dhbc.model.ArrayMangHinhChoi;
import com.hgk.giakhanh.dhbc.model.HinhAnhChoi;
import com.hgk.giakhanh.dhbc.model.KyTuVaButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlayActivity extends AppCompatActivity{
    ArrayMangHinhChoi tiengAnh, tiengViet;
    ArrayList<HinhAnhChoi> hinhAnhTiengViet, hinhAnhTiengAnh;
    ArrayList<Integer> listIDDaChoi = new ArrayList<>();
    HinhAnhChoi hinhAnhChoi;
    String tenNguoiChoi;
    int ngonNgu;
    ImageView hinhAnh;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btnXoa, btnXacNhan;
    TextView edtResult;
    int diamond = 0;
    TextView txtDiamond;
    ImageButton imgbHint;
    int REQUEST_CODE = 123;
    int m = 0;
    //SharedPreferences để lưu kim cương có
    //SharedPreferences player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        AnhXa();
        Intent intent = getIntent();
        ngonNgu = intent.getIntExtra("NgonNgu", 123);
        tenNguoiChoi = intent.getStringExtra("TenNguoiChoi");
        hinhAnhTiengViet = new ArrayList<>();
        //them dua lieu
        themDataTiengViet(hinhAnhTiengViet);
        //khởi tạo SharedPreferences
        //player = getSharedPreferences("SoKimCuong", MODE_PRIVATE);
        //lấy kim cương lưu trong SharedPreferences
//        SharedPreferences.Editor editor = player.edit();
//        editor.putString("Name", tenNguoiChoi);
//        editor.commit();
//        if(player.getString("Name", "").equalsIgnoreCase(tenNguoiChoi) == false){
//            editor.remove("Diamond");
//            editor.commit();
//        }
//        diamond = player.getInt("Diamond", 5);

        tiengViet = new ArrayMangHinhChoi(hinhAnhTiengViet, ngonNgu, tenNguoiChoi, diamond);
        tiengViet.setDiamond(5);

        hinhAnhChoi = upData(tiengViet,m);
        xuLyButton(hinhAnhChoi,tiengViet);

//        do {
//            hinhAnhChoi = upData(tiengViet, m);
//           xuLyButton(hinhAnhChoi, tiengViet);
//          //  Toast.makeText(PlayActivity.this,m+"",Toast.LENGTH_SHORT).show();
//            if(check(hinhAnhChoi) == true) {
//                m++;
//            }
//            edtResult.setText(" ");
//        }while (m == tiengViet.getHinhAnhChoiArrayList().size() && m >=0);

    }
    protected void AnhXa(){
        hinhAnh = findViewById(R.id.imageViewAnhChoi);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        edtResult = findViewById(R.id.editTextResult);
        btnXoa = findViewById(R.id.buttonXoa);
        btnXacNhan = findViewById(R.id.buttonXacNhan);
        txtDiamond = findViewById(R.id.textViewDiamond);
        imgbHint = findViewById(R.id.imageButtonHint);
    }

    protected void themDataTiengViet(ArrayList<HinhAnhChoi> a){
        a.add(new HinhAnhChoi(15, R.drawable.vnhanhieu, "nhan hieu", "nhan hieu", " huinnhatcxe"));
        a.add(new HinhAnhChoi(2, R.drawable.vhailong, "hai long", "hai long", "klinhuoabgv "));
        a.add(new HinhAnhChoi(3, R.drawable.vthanghoa, "thang hoa", "thang hoa", "ahbnhgauito "));
        a.add(new HinhAnhChoi(4, R.drawable.vtichphan, "tich phan", "tich phan", "nphscthimha "));
        a.add(new HinhAnhChoi(5, R.drawable.vtoihauthu, "toi hau thu", "toi hau thu", "uhu othatik "));
        a.add(new HinhAnhChoi(1, R.drawable.vaimo, "ai mo", "ai mo", "md daoikbgqds"));
        a.add(new HinhAnhChoi(6, R.drawable.vcobap, "co bap", "co bap", "pckbpelaqmo "));
        a.add(new HinhAnhChoi(7, R.drawable.vauyem, "au yem", "au yem", "kmygn adueli"));
        a.add(new HinhAnhChoi(8, R.drawable.vbaomong, "bao mong", "bao mong", "gonbpelaqmo "));
        a.add(new HinhAnhChoi(9, R.drawable.vbaphai, "ba phai", "ba phai", "bvalp hyoafi"));
        a.add(new HinhAnhChoi(10, R.drawable.vcangian, "can gian", "can gian", "kcnigp qnaua"));
        a.add(new HinhAnhChoi(11, R.drawable.vkhoanhong, "khoan hong", "khoan hong", "gnkoano hihq"));
        a.add(new HinhAnhChoi(12, R.drawable.vkhotam, "kho tam", "kho tam", "pckjuh tmoia"));
        a.add(new HinhAnhChoi(13, R.drawable.vmatkhau, "mat khau", "mat khau", "t uknhmaayul"));
        a.add(new HinhAnhChoi(14, R.drawable.vquycu, "quy cu", "quy cu", "uu ckqnyuovx"));

        a.add(new HinhAnhChoi(16, R.drawable.vruatien, "rua tien", "rua tien", "nntki rouael"));
        a.add(new HinhAnhChoi(17, R.drawable.vxemtuong, "xem tuong", "xem tuong", "ungctoe ymvx"));
    }

    protected HinhAnhChoi upData(ArrayMangHinhChoi a, int i){
        hinhAnh.setImageResource(a.getHinhAnhChoiArrayList().get(i).getHinhAnh());
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(0) + "") == " "){
            btn1.setText("Space");
        }else{
           btn1.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(0) + "");

        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(1) + "") == " "){
            btn2.setText("Space");
        }else{
            btn2.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(1) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(2) + "") == " "){
            btn3.setText("Space");
        }else{
            btn3.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(2) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(3) + "") == " "){
            btn4.setText("Space");
        }else{
            btn4.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(3) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(4) + "") == " "){
            btn5.setText("Space");
        }else{
            btn5.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(4) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(5) + "") == " "){
            btn6.setText("Space");
        }else{
            btn6.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(5) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(6) + "") == " "){
            btn7.setText("Space");
        }else{
            btn7.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(6) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(7) + "") == " "){
            btn8.setText("Space");
        }else{
            btn8.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(7) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(8) + "") == " "){
            btn9.setText("Space");
        }else{
            btn9.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(8) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(9) + "") == " "){
            btn10.setText("Space");
        }else{
            btn10.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(9) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(10) + "") == " "){
            btn11.setText("Space");
        }else{
            btn11.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(10) + "");
        }
        if((a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(11) + "") == " "){
            btn12.setText("Space");
        }else{
            btn12.setText(a.getHinhAnhChoiArrayList().get(i).getKyTu().charAt(11) + "");
        }
        //if(edtResult.getText().toString() == ""){
            edtResult.setHint("Kết quả có: " + tiengViet.getHinhAnhChoiArrayList().get(i).getResult().length() + " ký tự");
        //}

        txtDiamond.setText(a.getDiamond() + "");
        return a.getHinhAnhChoiArrayList().get(i);
    }


    String result, hint;
    KyTuVaButton obj;
    ArrayList<KyTuVaButton> list = new ArrayList<>();
    String a;
    int temp = 0;
    protected void xuLyButton(final HinhAnhChoi a, final ArrayMangHinhChoi b){


        result = "";
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn1.getText().toString();
                edtResult.setText(result);
                if(btn1.getText().toString() != "")
                    list.add(new KyTuVaButton(1, btn1.getText().toString()));
                btn1.setText("");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn2.getText().toString();
                edtResult.setText(result);
                if(btn2.getText().toString() != "")
                    list.add(new KyTuVaButton(2, btn2.getText().toString()));
                btn2.setText("");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn3.getText().toString();
                edtResult.setText(result);
                if(btn3.getText().toString() != "")
                    list.add(new KyTuVaButton(3, btn3.getText().toString()));
                btn3.setText("");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn4.getText().toString();
                edtResult.setText(result);
                if(btn4.getText().toString() != "")
                    list.add(new KyTuVaButton(4, btn4.getText().toString()));
                btn4.setText("");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn5.getText().toString();
                edtResult.setText(result);
                if(btn5.getText().toString() != "")
                list.add(new KyTuVaButton(5, btn5.getText().toString()));
                btn5.setText("");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn6.getText().toString();
                edtResult.setText(result);
                if(btn6.getText().toString() != "")
                    list.add(new KyTuVaButton(6, btn6.getText().toString()));
                btn6.setText("");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn7.getText().toString();
                edtResult.setText(result);
                if(btn7.getText().toString() != "")
                    list.add(new KyTuVaButton(7, btn7.getText().toString()));
                btn7.setText("");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn8.getText().toString();
                edtResult.setText(result);
                if(btn8.getText().toString() != "")
                    list.add(new KyTuVaButton(8, btn8.getText().toString()));
                btn8.setText("");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn9.getText().toString();
                edtResult.setText(result);
                if(btn9.getText().toString() != "")
                    list.add(new KyTuVaButton(9, btn9.getText().toString()));
                btn9.setText("");
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn10.getText().toString();
                edtResult.setText(result);
                if(btn10.getText().toString() != "")
                    list.add(new KyTuVaButton(10, btn10.getText().toString()));
                btn10.setText("");
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn11.getText().toString();
                edtResult.setText(result);
                if(btn11.getText().toString() != "")
                    list.add(new KyTuVaButton(11, btn11.getText().toString()));
                btn11.setText("");
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = result + btn12.getText().toString();
                edtResult.setText(result);
                if(btn12.getText().toString() != "")
                    list.add(new KyTuVaButton(12, btn12.getText().toString()));
                btn12.setText("");
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edtResult.getText().toString();
                if(a.length() != 0){
                    a = a.substring(0, a.length() - 1);
                    edtResult.setText(a);
                    result = a;
                    obj = list.get(list.size() - 1);
                    switch (obj.getId()){
                        case 1:
                            btn1.setText(obj.getName());
                            break;
                        case 2:
                            btn2.setText(obj.getName());
                            break;
                        case 3:
                            btn3.setText(obj.getName());
                            break;
                        case 4:
                            btn4.setText(obj.getName());
                            break;
                        case 5:
                            btn5.setText(obj.getName());
                            break;
                        case 6:
                            btn6.setText(obj.getName());
                            break;
                        case 7:
                            btn7.setText(obj.getName());
                            break;
                        case 8:
                            btn8.setText(obj.getName());
                            break;
                        case 9:
                            btn9.setText(obj.getName());
                            break;
                        case 10:
                            btn10.setText(obj.getName());
                            break;
                        case 11:
                            btn11.setText(obj.getName());
                            break;
                        case 12:
                            btn12.setText(obj.getName());
                            break;
                    }
                    list.remove(list.size() - 1);
                }
            }
        });
        imgbHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // if (b.getDiamond() >0){
//                    for (int i=0; i < b.getHinhAnhChoiArrayList().size(); i++){
//
//                        hint = b.getHinhAnhChoiArrayList().get(i).getHint();
//
//                        for (int j=i; j < b.getHinhAnhChoiArrayList().get(i).getHint().length(); j++){
//                            edtResult.append(b.getHinhAnhChoiArrayList().get(i).getHint().charAt(j) + "");
//                            hint = hint.substring(j,hint.length());
//                            b.setDiamond(b.getDiamond() - 1);
//                            txtDiamond.setText(b.getDiamond() + " ");
//                        }
//                     }
               // }
                if (b.getDiamond() > 0){
                    edtResult.append(a.getResult());
                    b.setDiamond(b.getDiamond() - 1);
                    txtDiamond.setText(b.getDiamond() + " ");
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(PlayActivity.this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Kim cương không đủ, cố gắng thêm ");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }

            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check(a) == false){
                    // Toast.makeText(PlayActivity.this, "Sai rồi bạn ơi!!", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder b1 = new AlertDialog.Builder(PlayActivity.this);
                    b1.setTitle("Bạn sai rồi!!!");
                    b1.setMessage("Thử sức lại nào!!!");
                    b1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    b1.create().show();
                }else{
                    AlertDialog.Builder b2 = new AlertDialog.Builder(PlayActivity.this);
                            b2.setTitle("Chúc mừng bạn đã trả lời đúng!");
                            b2.setMessage("Bạn sẽ được cộng thêm 2 kim cương.");
                            b2.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    b.setDiamond(b.getDiamond() + 2);
                                    txtDiamond.setText(b.getDiamond() + "");
                        }
                    });
                                b2.setNegativeButton("Dừng", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                });
                    b2.create().show();

//                    if (m==tiengViet.getHinhAnhChoiArrayList().size()){
////                        AlertDialog.Builder b3 = new AlertDialog.Builder(PlayActivity.this);
////                        b3.setTitle("Thông Báo");
////                        b3.setMessage("Chúc mừng bạn đã hoàn thành phần chơi của mình");
////                        b3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialog, int which) {
////                                finish();
////                            }
////                        });
////                        b3.create().show();
//                        Intent intent = new Intent(PlayActivity.this,MainActivity.class);
//                        startActivity(intent);
//                    }
//                    else {
//                        AlertDialog.Builder b2 = new AlertDialog.Builder(PlayActivity.this);
//                        b2.setTitle("Chúc mừng bạn đã trả lời đúng!");
//                        b2.setMessage("Bạn sẽ được cộng thêm 2 kim cương.");
//                        b2.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                b.setDiamond(b.getDiamond() + 2);
//                                txtDiamond.setText(b.getDiamond() + "");
//                            }
//                        });
//                        b2.setNegativeButton("Tạm dừng", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
//                            }
//                        });
//                        b2.create().show();
//                    }


                    for (int i =m+1 ;i<tiengViet.getHinhAnhChoiArrayList().size();i++){
                        if (check(a)==true)
                        {
                            do {
                                hinhAnhChoi = upData(tiengViet, i);
                                xuLyButton(hinhAnhChoi, tiengViet);
                                //Toast.makeText(PlayActivity.this,m+"",Toast.LENGTH_SHORT).show();
//                                if(check(hinhAnhChoi)==true) {
//                                  // i++;
//                                    m++;
//                                }
                                m++;
                                edtResult.setText(" ");
                            }while (i == tiengViet.getHinhAnhChoiArrayList().size() && i>=0);
                        }

//                        if (m == tiengViet.getHinhAnhChoiArrayList().size()){
//                            AlertDialog.Builder b3 = new AlertDialog.Builder(PlayActivity.this);
//                            b3.setTitle("Thông Báo");
//                            b3.setMessage("Chúc mừng bạn đã hoàn thành phần chơi của mình");
//                            b3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            });
//                            b3.create().show();
//                        }
                    }



              }
            }
        });
       //return temp;
    }

    private boolean check(final HinhAnhChoi a){
        if (edtResult.getText().toString().equalsIgnoreCase(a.getResult()))
            return true;
        return false;
    }

}
