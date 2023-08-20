package com.example.client_mob403.user;

import java.util.List;

public class user {

    List<userModel> list;

    @Override
    public String toString() {
        return "user{" +
                "list=" + list +
                '}';
    }

    public List<userModel> getList() {
        return list;
    }

    public void setList(List<userModel> list) {
        this.list = list;
    }

    public user() {
    }

    public user(List<userModel> list) {
        this.list = list;
    }
}
