package com.android.baranghilang.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.baranghilang.R;
import com.android.baranghilang.data.Data;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends ArrayAdapter<Data> {
    private LayoutInflater inflater;
    private List<Data> itemlist;
    private Context context;

    public Adapter(List<Data> itemlist, Context context) {
        super(context, R.layout.list_data, itemlist);
        this.itemlist = itemlist;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_data, null);

        TextView id = (TextView) convertView.findViewById(R.id.id_brghilang);
        TextView nama = (TextView) convertView.findViewById(R.id.txt_nama_barang);
        TextView detail = (TextView) convertView.findViewById(R.id.txt_Detail);
        TextView waktu = (TextView) convertView. findViewById(R.id.txt_waktu_ditemukan);
        ImageView src = (ImageView) convertView.findViewById(R.id.img_foto);

        Data data = itemlist.get(position);

        id.setText(data.getId_brghilang());
        nama.setText(data.getNama());
        detail.setText(data.getDetail());
        waktu.setText(data.getWaktu());
        Glide.with(context).load(data.getSrc()).into(src);

        return convertView;
    }

}
