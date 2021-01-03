package com.example.prototype;

import android.os.Bundle;

import com.example.prototype.ui.main.SectionsPagerAdapterACT;
import com.example.prototype.ui.main.SectionsPagerAdapterDateTime;
import com.example.prototype.ui.main.SectionsPagerAdapterLinnierLayout;
import com.example.prototype.ui.main.SectionsPagerAdapterMapView;
import com.example.prototype.ui.main.SectionsPagerAdapterProgressBar;
import com.example.prototype.ui.main.SectionsPagerAdapterWebView;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prototype.ui.main.SectionsPagerAdapterSpinner;

public class Tabslayout extends AppCompatActivity {
    public static final String EXTRA_DATA="nama";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabslayout);

        String nama=getIntent().getStringExtra(EXTRA_DATA);

        if (nama.equals("Spinner")){
            SectionsPagerAdapterSpinner sectionsPagerAdapterSpinner = new SectionsPagerAdapterSpinner(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapterSpinner);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("ACT")){
            SectionsPagerAdapterACT sectionsPagerAdapter = new SectionsPagerAdapterACT(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("WebView")){
            SectionsPagerAdapterWebView sectionsPagerAdapter = new SectionsPagerAdapterWebView(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("ProgressBar")){
            SectionsPagerAdapterProgressBar sectionsPagerAdapter = new SectionsPagerAdapterProgressBar(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("LinnierLayout")){
            SectionsPagerAdapterLinnierLayout sectionsPagerAdapter = new SectionsPagerAdapterLinnierLayout(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("MapView")){
            SectionsPagerAdapterMapView sectionsPagerAdapter = new SectionsPagerAdapterMapView(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }else if (nama.equals("DateTime")){
            SectionsPagerAdapterDateTime sectionsPagerAdapter = new SectionsPagerAdapterDateTime(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }
    }
}