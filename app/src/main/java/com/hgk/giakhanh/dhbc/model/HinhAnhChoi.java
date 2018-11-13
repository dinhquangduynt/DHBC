package com.hgk.giakhanh.dhbc.model;

import java.util.ArrayList;

public class HinhAnhChoi {
        private int topicID;
        private int hinhAnh;
        String result;
        private String hint;
        private String kyTu;

    public HinhAnhChoi(int topicID, int hinhAnh, String result, String hint, String kyTu) {
        this.topicID = topicID;
        this.hinhAnh = hinhAnh;
        this.result = result;
        this.hint = hint;
        this.kyTu = kyTu;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getKyTu() {
        return kyTu;
    }

    public void setKyTu(String kyTu) {
        this.kyTu = kyTu;
    }
}
