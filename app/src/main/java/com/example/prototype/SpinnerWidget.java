package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SpinnerWidget extends AppCompatActivity {
    EditText namapanjang;
    EditText nim;
    Spinner jurusan;
    Button simpan;
    public int[] judul={1,2,3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_widget);
        FloatingActionButton fab =findViewById(R.id.fab_btn);
        namapanjang=(EditText)findViewById(R.id.edt_namapanjang);
        nim=(EditText)findViewById(R.id.edt_nim);
        jurusan=(Spinner)findViewById(R.id.spn_jurusan);
        simpan=(Button)findViewById(R.id.btn_simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(SpinnerWidget.this);
                dialog.setTitle("@String/dtaMhs");
                dialog.setContentView(R.layout.layout_dialog);
                TextView txt=(TextView)dialog.findViewById(R.id.desc);
                txt.setText("\nNama     : "+namapanjang.getText().toString()
                        +"\nNIM  : "+nim.getText().toString()
                        +"\nJurusan  : "+jurusan.getSelectedItem().toString());
                Button dialogButton=(Button)dialog.findViewById(R.id.dilBut);
                dialogButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpinnerWidget.this,Tabslayout.class);
                i.putExtra(Tabslayout.EXTRA_DATA,"Spinner");
                startActivity(i);
            }
        });
    }

}