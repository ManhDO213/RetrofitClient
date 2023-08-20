package com.example.client_mob403.truyentranh;

public class binhluanModel {
    private String _id;
    private String idTruyen;
    private String idUser;
    private String noiDung;
    private String nameUser;
    private String date;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(String idTruyen) {
        this.idTruyen = idTruyen;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public binhluanModel() {
    }

    public binhluanModel(String _id, String idTruyen, String idUser, String noiDung, String date, String nameUser) {
        this._id = _id;
        this.idTruyen = idTruyen;
        this.idUser = idUser;
        this.noiDung = noiDung;
        this.date = date;
        this.nameUser = nameUser;
    }
}
