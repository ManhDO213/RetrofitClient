package com.example.client_mob403;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.client_mob403.databinding.ActivityChiTietTtactivityBinding;
import com.example.client_mob403.truyentranh.binhluanAdapter;
import com.example.client_mob403.truyentranh.binhluanModel;
import com.example.client_mob403.truyentranh.truyenTranhCT;
import com.example.client_mob403.truyentranh.truyentranh;
import com.example.client_mob403.truyentranh.truyentranhAdapter;
import com.example.client_mob403.truyentranh.truyentranhModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietTTActivity extends AppCompatActivity {
    private truyentranhModel truyentranhModel = new truyentranhModel();
    private binhluanAdapter adapter;
    private List<binhluanModel> listBLModel = new ArrayList<>();
    private TextView tvTenTruyenChiTiet, tvTacGiaChiTiet, tvNamXBChiTiet, tvMoTaChiTiet;
    private ListView listView;
    private Button btnGuiBinhLuan, btnReadTT;
    private EditText edtBinhLuan;
    private ImageView imgAnhBiaChiTiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ttactivity);
        tvTenTruyenChiTiet = findViewById(R.id.tvTenTruyenChiTiet);
        tvTacGiaChiTiet = findViewById(R.id.tvTacGiaChiTiet);
        tvNamXBChiTiet = findViewById(R.id.tvNamXBChiTiet);
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet);
        listView = findViewById(R.id.lvBinhLuan);
        btnGuiBinhLuan = findViewById(R.id.btnGuiBinhLuan);
        btnReadTT = findViewById(R.id.btnReadTT);
        edtBinhLuan = findViewById(R.id.edtBinhLuan);
        imgAnhBiaChiTiet = findViewById(R.id.imgAnhBiaChiTiet);
        Intent intent = getIntent();
        TruyenManagerService truyenManagerService = RetrofitClient.getTruyenService();
        Call<ApiResponse<truyenTranhCT>> call = truyenManagerService.getTruyen(intent.getStringExtra("_id"));
        call.enqueue(new Callback<ApiResponse<truyenTranhCT>>() {
            @Override
            public void onResponse(Call<ApiResponse<truyenTranhCT>> call, Response<ApiResponse<truyenTranhCT>> response) {
                ApiResponse<truyenTranhCT> apiResponse = response.body();
                truyentranhModel = apiResponse.getData().getTT();
                tvTenTruyenChiTiet.setText(truyentranhModel.getTenTruyen());
                tvTacGiaChiTiet.setText( "Tác giả: " + truyentranhModel.getTacGia());
                tvNamXBChiTiet.setText("Năm XB: "+ truyentranhModel.getNamXB());
                tvMoTaChiTiet.setText(truyentranhModel.getMoTa());
                Glide.with(getApplicationContext()).load(truyentranhModel.getAnhBia()).into(imgAnhBiaChiTiet);
                listBLModel = truyentranhModel.getArr_binhluan();
                Log.d("zzzz", "onResponse: " + listBLModel.size());
                adapter = new binhluanAdapter(ChiTietTTActivity.this, listBLModel);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ApiResponse<truyenTranhCT>> call, Throwable t) {
                Log.d("zzzz", "Errol: " + t.getMessage());
            }
        });

        btnGuiBinhLuan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                String _idUser = sharedPreferences.getString("_idUser", "");
                String nameUser = sharedPreferences.getString("username", "");
                binhluanModel binhluanModel = new binhluanModel();
                binhluanModel.setIdTruyen(intent.getStringExtra("_id"));
                binhluanModel.setNoiDung(edtBinhLuan.getText().toString());
                binhluanModel.setDate(LocalDateTime.now().toString());
                binhluanModel.setIdUser(_idUser);
                binhluanModel.setNameUser(nameUser);

                Call call = truyenManagerService.addBinhLuan(binhluanModel);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if (response.isSuccessful()) {
                            truyentranhModel.getArr_binhluan().add(binhluanModel);
                            adapter.notifyDataSetChanged();
                            edtBinhLuan.setText("");
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.d("zzzz", "Errol: " + t.getMessage());
                    }
                });
            }
        });

        btnReadTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietTTActivity.this, ReadTTActivity.class);
                intent.putExtra("_id", truyentranhModel.get_id());
                startActivity(intent);
            }
        });
    }
}