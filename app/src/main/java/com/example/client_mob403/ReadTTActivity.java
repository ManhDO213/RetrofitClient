package com.example.client_mob403;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.client_mob403.databinding.ActivityReadTtactivityBinding;
import com.example.client_mob403.truyentranh.imageTTAdapter;
import com.example.client_mob403.truyentranh.truyenTranhCT;
import com.example.client_mob403.truyentranh.truyentranhModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadTTActivity extends AppCompatActivity {
    ActivityReadTtactivityBinding binding;
    private truyentranhModel truyentranhModel = new truyentranhModel();
    private imageTTAdapter imageTTAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadTtactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        TruyenManagerService truyenManagerService = RetrofitClient.getTruyenService();
        Call<ApiResponse<truyenTranhCT>> call = truyenManagerService.getTruyen(intent.getStringExtra("_id"));
        call.enqueue(new Callback<ApiResponse<truyenTranhCT>>() {
            @Override
            public void onResponse(Call<ApiResponse<truyenTranhCT>> call, Response<ApiResponse<truyenTranhCT>> response) {
                ApiResponse<truyenTranhCT> apiResponse = response.body();
                truyentranhModel = apiResponse.getData().getTT();
                Log.d("zzzz", "onResponse: " + truyentranhModel.getAnh().size());
                imageTTAdapter = new imageTTAdapter(getApplicationContext(), truyentranhModel.getAnh());
                binding.lvAnhTT.setAdapter(imageTTAdapter);
            }

            @Override
            public void onFailure(Call<ApiResponse<truyenTranhCT>> call, Throwable t) {
                Log.d("zzzz", "Errol: " + t.getMessage());
            }
        });
    }
}