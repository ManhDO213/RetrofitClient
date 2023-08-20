package com.example.client_mob403;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.client_mob403.truyentranh.truyenTranhCT;
import com.example.client_mob403.user.objUser;
import com.example.client_mob403.user.userModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {
    private EditText edtTenDangNhap;
    private EditText edtMatKhau;
    private Button btnDangNhap;
    private Button btnDangKi;
    private List<userModel> list = new ArrayList<userModel>();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edtTenDangNhap.getText().toString()) || TextUtils.isEmpty(edtMatKhau.getText().toString())){
                    Toast.makeText(SigninActivity.this,"Username / Password Required", Toast.LENGTH_LONG).show();
                }
                else {
                    login();
                }

            }
        });

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sDialog();
            }
        });
    }

    private void login(){
        userModel u = new userModel();
        String username = edtTenDangNhap.getText().toString();
        u.setUsername(username);
        String passwd = edtMatKhau.getText().toString();
        u.setPasswd(passwd);
        UserManagerService userManagerService = RetrofitClient.getService();
        Log.e("login", "onResponse: " + list);
        // Log.e("login", "list: " + u.getUsername() + "Pass: " + u.getPasswd());
        Log.e("model", "onClick: "+ u.getUsername() );
        Call<ApiResponse<objUser>> call = userManagerService.loginUser(u);
        call.enqueue(new Callback<ApiResponse<objUser>>() {
            @Override
            public void onResponse(Call<ApiResponse<objUser>> call, Response<ApiResponse<objUser>> response) {
                Log.e("respon", "onResponse: " + response.body() );
                if (response.isSuccessful()){
                    Log.e("respon", "onResponse: " + response.isSuccessful() );
                    ApiResponse<objUser> apiResponse = response.body();
                    Log.e("respon", "apiResponse: " + apiResponse.getData().getObjUser().get_id() );
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("_idUser", apiResponse.getData().getObjUser().get_id());
                    editor.putString("username", apiResponse.getData().getObjUser().getUsername());
                    editor.putString("fullname", apiResponse.getData().getObjUser().getFullname());
                    editor.putString("email", apiResponse.getData().getObjUser().getEmail());

                    editor.apply();

                    Toast.makeText(SigninActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SigninActivity.this,"Login Fail", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ApiResponse<objUser>> call, Throwable t) {
                Toast.makeText(SigninActivity.this, "That bai ", Toast.LENGTH_SHORT).show();
                Log.d("zzzz", "onFailure: "+t.getMessage());
            }
        });
    }

    private void sDialog(){
        final Dialog dialog = new Dialog(SigninActivity.this);
        dialog.setContentView(R.layout.custom_dialog_login);

        EditText edtTenDangKi = dialog.findViewById(R.id.edtTenDangKi);
        EditText edtMatKhauDK = dialog.findViewById(R.id.edtMatKhauDK);
        EditText edtEmail = dialog.findViewById(R.id.edtEmail);
        EditText edtFullname = dialog.findViewById(R.id.edtFullname);
        Button btnOk = dialog.findViewById(R.id.btnOk);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        // if button is clicked, close the custom dialog
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //xử lí sự kiện

                userModel u = new userModel();
                u.setUsername(edtTenDangKi.getText().toString());
                u.setPasswd(edtMatKhauDK.getText().toString());
                u.setEmail(edtEmail.getText().toString());
                u.setFullname(edtFullname.getText().toString());

                UserManagerService userManagerService =RetrofitClient.getService();
                Call call = userManagerService.addUser(u);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Toast.makeText(SigninActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(SigninActivity.this, "Fail !", Toast.LENGTH_SHORT).show();
                    }
                });
                // dialog.dismiss();
            }
        });
        dialog.show();
    }

}