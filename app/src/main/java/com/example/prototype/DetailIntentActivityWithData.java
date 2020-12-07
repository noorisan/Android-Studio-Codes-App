package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailIntentActivityWithData extends AppCompatActivity {
public static final String EXTRA_NAMA="nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_intent_with_data);
        TextView tvNamaDetail=findViewById(R.id.nama_detail);
        ImageView gambar= findViewById(R.id.gambar);
        String nama=getIntent().getStringExtra(EXTRA_NAMA);
        String text=nama;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("pic");
            gambar.setImageResource(resId);
        }
        tvNamaDetail.setText(text);
    }
}