package com.example.client_mob403.user;

public class userModel {
    private String _id;
    private String username, passwd,email, fullname;

    public userModel() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public userModel(String _id, String username, String passwd, String email, String fullname) {
        this._id = _id;
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.fullname = fullname;
    }
}
