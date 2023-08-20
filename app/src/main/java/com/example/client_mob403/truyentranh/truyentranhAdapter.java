package com.example.client_mob403.truyentranh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.client_mob403.R;

import java.util.List;

public class truyentranhAdapter extends BaseAdapter {
    private List<truyentranhModel> list;
    private LayoutInflater layoutInflater;
    private Context context;


    public truyentranhAdapter(List<truyentranhModel> list, Context context) {
        this.list = list;
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        viewH view;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_truyentranh, null);
            view = new viewH();
            view.imgAnhBia = convertView.findViewById(R.id.imgAnhBia);
            view.tvName = convertView.findViewById(R.id.tvTenTruyen);
            convertView.setTag(view);
        } else {
            view = (viewH) convertView.getTag();
        }

        truyentranhModel truyentranhModel = this.list.get(position);
        Glide.with(context).load(list.get(position).getAnhBia()).into(view.imgAnhBia);
        view.tvName.setText(truyentranhModel.getTenTruyen());

        return convertView;
    }

    static class viewH {
        ImageView imgAnhBia;
        TextView tvName;
    }
}
