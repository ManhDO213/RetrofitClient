package com.example.client_mob403;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.client_mob403.truyentranh.truyentranh;
import com.example.client_mob403.truyentranh.truyentranhAdapter;
import com.example.client_mob403.truyentranh.truyentranhModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private List<truyentranhModel> list = new ArrayList<truyentranhModel>();
    private truyentranhAdapter adapter;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView listView = view.findViewById(R.id.lv);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),ChiTietTTActivity.class);
                intent.putExtra("_id",list.get(i).get_id());
                startActivity(intent);
            }
        });
        TruyenManagerService truyenManagerService = RetrofitClient.getTruyenService();
        Call<ApiResponse<truyentranh>> call = truyenManagerService.getListUser();
        call.enqueue(new Callback<ApiResponse<truyentranh>>() {
            @Override
            public void onResponse(Call<ApiResponse<truyentranh>> call, Response<ApiResponse<truyentranh>> response) {
                ApiResponse<truyentranh> apiResponse = response.body();
                list = apiResponse.getData().getListTT();
             //   Log.d("zzzz", "Array: " + list.get(0).getArr_binhluan().get(0).get_id());
                adapter = new truyentranhAdapter(list, getContext());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ApiResponse<truyentranh>> call, Throwable t) {
                Log.d("zzzz", "Errol: " + t.getMessage());
            }
        });
        return view;
    }
}