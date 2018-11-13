package com.hgk.giakhanh.dhbc.model;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class ArrayMangHinhChoi {
    ArrayList<HinhAnhChoi> hinhAnhChoiArrayList;
    int ngonNgu;
    String tenNguoiChoi;
    int diamond;

    public ArrayMangHinhChoi(ArrayList<HinhAnhChoi> hinhAnhChoiArrayList, int ngonNgu, String tenNguoiChoi, int diamond) {
        this.hinhAnhChoiArrayList = hinhAnhChoiArrayList;
        this.ngonNgu = ngonNgu;
        this.tenNguoiChoi = tenNguoiChoi;
        this.diamond = diamond;
    }

    public ArrayList<HinhAnhChoi> getHinhAnhChoiArrayList() {
        return hinhAnhChoiArrayList;
    }

    public void setHinhAnhChoiArrayList(ArrayList<HinhAnhChoi> hinhAnhChoiArrayList) {
        this.hinhAnhChoiArrayList = hinhAnhChoiArrayList;
    }

    public int getDoKho() {
        return ngonNgu;
    }

    public void setDoKho(int ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getTenNguoiChoi() {
        return tenNguoiChoi;
    }

    public void setTenNguoiChoi(String tenNguoiChoi) {
        this.tenNguoiChoi = tenNguoiChoi;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(int ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

}
