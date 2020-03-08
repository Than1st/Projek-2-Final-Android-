package com.android.baranghilang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_logout;
    TextView txt_nim, txt_nama;
    String nim, nama;
    SharedPreferences sharedpreferences;

    public static final String TAG_NIM = "nim";
    public static final String TAG_NAMA = "nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nim = (TextView) findViewById(R.id.txt_nim);
        txt_nama = (TextView) findViewById(R.id.txt_nama);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        nim = getIntent().getStringExtra(TAG_NIM);
        nama = getIntent().getStringExtra(TAG_NAMA);

        txt_nim.setText(nim);
        txt_nama.setText(nama);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(Login.session_status, false);
                editor.putString(TAG_NIM, null);
                editor.putString(TAG_NAMA, null);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Login.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
