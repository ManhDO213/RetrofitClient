package com.example.client_mob403.truyentranh;

import androidx.annotation.NonNull;

import java.util.List;

public class truyentranh {
    List<truyentranhModel> listTT;

    public List<truyentranhModel> getListTT() {
        return listTT;
    }

    public void setListTT(List<truyentranhModel> listTT) {
        this.listTT = listTT;
    }

    @NonNull
    @Override
    public String toString() {
        return "{list = '"+ listTT+"' }";
    }
}
