package com.example.client_mob403.user;

import androidx.annotation.NonNull;

public class objUser {
    userModel objUser;

    public userModel getObjUser() {
        return objUser;
    }

    public void setObjUser(userModel objUser) {
        this.objUser = objUser;
    }

    @NonNull
    @Override
    public String toString() {
        return "{userModel = '" + objUser + "' }";
    }
}
