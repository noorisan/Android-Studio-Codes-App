package com.example.prototype;

import android.os.Bundle;

import com.example.prototype.ui.main.SectionsPagerAdapterACT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.prototype.ui.main.SectionsPagerAdapter;

public class Tabslayout extends AppCompatActivity {
    public static final String EXTRA_DATA="nama";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabslayout);

        String nama=getIntent().getStringExtra(EXTRA_DATA);

        if (nama.equals("Spinner")){
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("ACT")){
            SectionsPagerAdapterACT sectionsPagerAdapter = new SectionsPagerAdapterACT(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }



    }
}