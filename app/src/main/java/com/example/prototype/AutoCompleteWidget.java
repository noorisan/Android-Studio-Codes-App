package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AutoCompleteWidget extends AppCompatActivity {
AutoCompleteTextView AutoCompleteTextViewDemo;
MultiAutoCompleteTextView MultiAutoCompleteTextViewDemo;
TextView txtautotext;
String[] namalist={"Abdul","Budi","Cinta","Dodi","Edy","Farhan","Gading","Hadi","Isan","Joko","Kriss","Loli","Muli","Noor","Odading","Putri","Qiqi","Rutmeida","Sumanto","Tini","Udil","Viva","Wendy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_widget);
        FloatingActionButton fab =findViewById(R.id.fab_btn);
        AutoCompleteTextViewDemo =(AutoCompleteTextView) findViewById(R.id.AutoCompleteTextDemo);
        MultiAutoCompleteTextViewDemo=(MultiAutoCompleteTextView) findViewById(R.id.MultiAutoCompleteTextDemo);
        txtautotext=(TextView)findViewById(R.id.txtautotext);
        StringBuilder editText=new StringBuilder();
        editText.append("List Nama").append("\n");
        for (String value:namalist){
            editText.append(value).append(",");
        }
        txtautotext.setText(editText);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,namalist);
        AutoCompleteTextViewDemo.setAdapter(adapter);
        MultiAutoCompleteTextViewDemo.setAdapter(adapter);

        AutoCompleteTextViewDemo.setThreshold(1);
        AutoCompleteTextViewDemo.setAdapter(adapter);

        MultiAutoCompleteTextViewDemo.setThreshold(1);
        MultiAutoCompleteTextViewDemo.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AutoCompleteWidget.this,Tabslayout.class);
                i.putExtra(Tabslayout.EXTRA_DATA,"ACT");
                startActivity(i);
            }
        });
    }
}