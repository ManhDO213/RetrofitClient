package com.example.client_mob403.truyentranh;

import androidx.annotation.NonNull;


public class truyenTranhCT {

    truyentranhModel truyenTranh;

    public truyentranhModel getTT() {
        return truyenTranh;
    }

    public void setTT(truyentranhModel truyenTranh) {
        this.truyenTranh = truyenTranh;
    }

    @NonNull
    @Override
    public String toString() {
        return "{truyenTranh = '" + truyenTranh + "' }";
    }


}
