package com.example.client_mob403.truyentranh;

import java.util.List;

public class truyentranhModel {
    private String _id;
    private String tenTruyen;
    private String moTa;
    private String tacGia;
    private int namXB;
    private String anhBia;
    private List<String> anh;
    private List<binhluanModel> arr_binhluan;


    @Override
    public String toString() {
        return "truyentranhModel{" +
                "_id=" + _id +
                ", tenTruyen='" + tenTruyen + '\'' +
                ", moTa='" + moTa + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", namXB=" + namXB +
                ", anhBia='" + anhBia + '\'' +
                ", anh='" + anh + '\'' +
                ", arr_binhluan=" + arr_binhluan +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public String getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(String anhBia) {
        this.anhBia = anhBia;
    }

    public List<String> getAnh() {
        return anh;
    }

    public void setAnh(List<String> anh) {
        this.anh = anh;
    }

    public List<binhluanModel> getArr_binhluan() {
        return arr_binhluan;
    }

    public void setArr_binhluan(List<binhluanModel> arr_binhluan) {
        this.arr_binhluan = arr_binhluan;
    }

    public truyentranhModel() {
    }

    public truyentranhModel(String _id, String tenTruyen, String moTa, String tacGia, int namXB, String anhBia, List<String> anh, List<binhluanModel> arr_binhluan) {
        this._id = _id;
        this.tenTruyen = tenTruyen;
        this.moTa = moTa;
        this.tacGia = tacGia;
        this.namXB = namXB;
        this.anhBia = anhBia;
        this.anh = anh;
        this.arr_binhluan = arr_binhluan;
    }
}
