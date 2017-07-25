package com.muhammadagung.pertemuan4_drawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    TextView judul, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        judul = (TextView) findViewById(R.id.txtJudul);
        harga = (TextView) findViewById(R.id.txtHarga2);

        Intent intent = getIntent();
        judul.setText(intent.getStringExtra("judul"));
        harga.setText(intent.getStringExtra("harga"));
        getSupportActionBar().setTitle(intent.getStringExtra("judul"));
    }
}
