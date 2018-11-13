package com.hgk.giakhanh.dhbc.model;

public class KyTuVaButton {
    int id;
    String name;

    public KyTuVaButton(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
