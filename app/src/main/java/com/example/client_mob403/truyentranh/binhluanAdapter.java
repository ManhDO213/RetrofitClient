package com.example.client_mob403.truyentranh;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.client_mob403.R;

import java.util.List;

public class binhluanAdapter extends BaseAdapter {

    private Context context;
    private List<binhluanModel> líst;


    public binhluanAdapter(Context context, List<binhluanModel> líst) {
        this.context = context;
        this.líst = líst;
    }

    @Override
    public int getCount() {
        return líst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.item_binhluan, null);

        TextView tvTenUser, tvNoiDung, tvDate;
        tvTenUser = (TextView) convertView.findViewById(R.id.tvTenUser);
        tvNoiDung = (TextView) convertView.findViewById(R.id.tvNoiDungBinhLuan);
        tvDate = (TextView) convertView.findViewById(R.id.tvDate);



        binhluanModel binhluanModel = this.líst.get(position);
        tvNoiDung.setText(binhluanModel.getNoiDung());
        tvTenUser.setText(binhluanModel.getNameUser());
        tvDate.setText(binhluanModel.getDate());
        return convertView;
    }
}