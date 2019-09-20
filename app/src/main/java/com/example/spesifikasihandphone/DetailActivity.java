package com.example.spesifikasihandphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static String KEY_ACTIVITY;
    private TextView NamaProduk,Ram, InternalMemory,Harga;
    private ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        NamaProduk=(TextView)findViewById(R.id.txt_nama_produk);
        Ram=(TextView)findViewById(R.id.txt_ram);
        InternalMemory=(TextView)findViewById(R.id.txt_internal_memory);
        Image=(ImageView)findViewById(R.id.img_hp);
        Harga=(TextView) findViewById(R.id.txt_harga);


        Intent intent=getIntent();
        Handphone hpnya=(Handphone)intent.getSerializableExtra(KEY_ACTIVITY);
        NamaProduk.setText(hpnya.getNama_produk());
        Ram.setText(hpnya.getRam());
        InternalMemory.setText(hpnya.getInternal_memory());
        Harga.setText(hpnya.getHarga());
        Picasso.with(this).load(hpnya.getPic()).into(Image);
    }
}
