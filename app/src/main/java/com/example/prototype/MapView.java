package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapView extends AppCompatActivity {

    Button btnSearch;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        FloatingActionButton fab =findViewById(R.id.fab_btn);
        btnSearch=findViewById(R.id.btnSearch);
        editText=findViewById(R.id.edtSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri=Uri.parse("geo:0,0?q="+editText.getText().toString());
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapView.this,Tabslayout.class);
                i.putExtra(Tabslayout.EXTRA_DATA,"MapView");
                startActivity(i);
            }
        });
    }
}