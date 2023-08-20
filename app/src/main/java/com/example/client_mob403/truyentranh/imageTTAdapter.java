package com.example.client_mob403.truyentranh;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.client_mob403.R;

import java.util.List;

public class imageTTAdapter extends BaseAdapter {

    private Context context;
    private List<String> líst;


    public imageTTAdapter(Context context, List<String> líst) {
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
        convertView = mInflater.inflate(R.layout.item_image_tt, null);

        ImageView imageTT;
        imageTT = (ImageView) convertView.findViewById(R.id.imgListAnh);

        Glide.with(context).load(líst.get(position)).into(imageTT);
        return convertView;
    }
}