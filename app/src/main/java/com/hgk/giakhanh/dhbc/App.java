package com.hgk.giakhanh.dhbc;

import android.support.v7.app.AppCompatActivity;

public class App {
    public static void restartApp(AppCompatActivity appCompatActivity){
        appCompatActivity.recreate();
    }

    public static void finishApp(AppCompatActivity appCompatActivity){
        appCompatActivity.finish();
    }
}
