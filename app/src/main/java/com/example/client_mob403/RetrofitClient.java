package com.example.client_mob403;

import com.example.client_mob403.truyentranh.binhluanModel;
import com.example.client_mob403.truyentranh.truyenTranhCT;
import com.example.client_mob403.truyentranh.truyentranh;
import com.example.client_mob403.truyentranh.truyentranhModel;
import com.example.client_mob403.user.objUser;
import com.example.client_mob403.user.user;
import com.example.client_mob403.user.userModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class RetrofitClient {
    private static final String BaseUrl = "http://192.168.16.105:3001/";

    public static UserManagerService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UserManagerService.class);
    }

    public static TruyenManagerService getTruyenService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(TruyenManagerService.class);
    }
}


interface UserManagerService {
    @GET("users")
    Call<ApiResponse<user>> getListUser();

    @POST("users/add-user")
    Call<Object> addUser(@Body userModel requestData);

    @POST("users/login")
    Call<ApiResponse<objUser>> loginUser(@Body userModel requestData);

}

interface TruyenManagerService {
    @GET("listTruyen")
    Call<ApiResponse<truyentranh>> getListUser();

    @GET("/chitiet/{idsp}")
    Call<ApiResponse<truyenTranhCT>> getTruyen(@Path("idsp") String idsp);

    @POST("/binhluan/add-binh-luan")
    Call<Object> addBinhLuan(@Body binhluanModel binhluanModel);
}


