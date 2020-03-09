package com.android.baranghilang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.baranghilang.app.AppController;
import com.android.baranghilang.data.Data;
import com.android.baranghilang.util.Server;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.baranghilang.Login.TAG_NIM;
import static com.android.baranghilang.Login.my_shared_preferences;
import static com.android.baranghilang.Login.session_status;

public class tampil_data extends AppCompatActivity {

    ListView list;
    Adapter adapter;
    String nim, nama;
    boolean session = false;
    List<Data> itemlist = new ArrayList<Data>();
    SharedPreferences sharedPreferences;

    private static String url_select     = Server.URL + "select.php";

    public static final String TAG_XNIM = "nim";
    public static final String TAG_XNAMA = "nama";

    private static final String TAG = tampil_data.class.getSimpleName();
    public static final String TAG_ID       = "id_brghilang";
    public static final String TAG_NAMA       = "nama";
    public static final String TAG_DETAIL       = "detail";
    public static final String TAG_WAKTU       = "waktu_ditemukan";
    public static final String TAG_IMAGE    = "src";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_data);
        list    = (ListView) findViewById(R.id.list_view);

        nim = getIntent().getStringExtra(TAG_XNIM);
        nama = getIntent().getStringExtra(TAG_XNAMA);
        sharedPreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(session_status, false);
        adapter = new com.android.baranghilang.adapter.Adapter(tampil_data.this, itemlist);
        list.setAdapter((BaseAdapter) adapter);
        if (session) {
            Intent intent = new Intent(tampil_data.this, MainActivity.class);
            intent.putExtra(TAG_NIM, nim);
            intent.putExtra(TAG_NAMA, nama);
        }
        callVolley();

    }

    private void callVolley(){
        itemlist.clear();
        ((BaseAdapter) adapter).notifyDataSetChanged();

        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        Data item = new Data();

                        item.setId_brghilang(object.getString(TAG_ID));
                        item.setNama(object.getString(TAG_NAMA));
                        item.setDetail(object.getString(TAG_DETAIL));
                        item.setWaktu(object.getString(TAG_WAKTU));

                        itemlist.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                ((BaseAdapter)adapter).notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(jArr);
    }


    public void back(View view) {
        Intent intent = new Intent(tampil_data.this, MainActivity.class);
        intent.putExtra(TAG_NIM, nim);
        intent.putExtra(TAG_NAMA, nama);
        startActivity(intent);
    }
}
