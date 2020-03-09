package com.android.baranghilang.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.baranghilang.R;
import com.android.baranghilang.data.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_data, null);

        TextView id = (TextView) convertView.findViewById(R.id.id_brghilang);
        TextView nama = (TextView) convertView.findViewById(R.id.txt_nama_barang);
        TextView detail = (TextView) convertView.findViewById(R.id.txt_Detail);
        TextView waktu = (TextView) convertView. findViewById(R.id.txt_waktu_ditemukan);
        ImageView src = (ImageView) convertView.findViewById(R.id.img_foto);

        Data data = items.get(position);

        id.setText(data.getId_brghilang());
        nama.setText(data.getNama());
        detail.setText(data.getDetail());
        waktu.setText(data.getWaktu());

        return convertView;
    }

}
