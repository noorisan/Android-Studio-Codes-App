package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteWidget extends AppCompatActivity {
AutoCompleteTextView AutoCompleteTextViewDemo;
TextView txtautotext;
String[] namalist={"Abdul","Budi","Cinta","Dodi","Edy","Farhan","Gading","Hadi","Isan","Joko","Kriss","Loli","Muli","Noor","Odading","Putri","Qiqi","Rutmeida","Sumanto","Tini","Udil","Viva","Wendy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_widget);
        AutoCompleteTextViewDemo =(AutoCompleteTextView) findViewById(R.id.AutoCompleteTextDemo);
        txtautotext=(TextView)findViewById(R.id.txtautotext);
        StringBuilder editText=new StringBuilder();
        editText.append("List Nama").append("\n");
        for (String value:namalist){
            editText.append(value).append(",");
        }
        txtautotext.setText(editText);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,namalist);
        AutoCompleteTextViewDemo.setAdapter(adapter);
        AutoCompleteTextViewDemo.setThreshold(1);
        AutoCompleteTextViewDemo.setAdapter(adapter);
    }
}