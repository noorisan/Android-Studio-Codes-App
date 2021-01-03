package com.example.prototype;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private String F;
    public Fragment1(String a){
        this.F=a;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getF().equals("MainActivityACT")){
            return inflater.inflate(R.layout.f_ma_act,container,false);
        }else if (getF().equals("Activity_MainACT")){
            return inflater.inflate(R.layout.f_am_act,container,false);
        }else if (getF().equals("MainActivitySpinner")){
            return inflater.inflate(R.layout.f_ma_spinner,container,false);
        }else if (getF().equals("Activity_MainSpinner")){
            return inflater.inflate(R.layout.f_am_spinner,container,false);
        }else if (getF().equals("MainActivityMapView")){
            return inflater.inflate(R.layout.f_ma_mapview,container,false);
        }else if (getF().equals("Activity_MainMapView")){
            return inflater.inflate(R.layout.f_am_mapview,container,false);
        }else if (getF().equals("MainActivityLinnierLayout")){
            return inflater.inflate(R.layout.f_ma_linnier,container,false);
        }else if (getF().equals("Activity_MainLinnierLayout")){
            return inflater.inflate(R.layout.f_am_linnier,container,false);
        }else if (getF().equals("MainActivityWebView")){
            return inflater.inflate(R.layout.f_ma_webview,container,false);
        }else if (getF().equals("Activity_MainWebView")){
            return inflater.inflate(R.layout.f_am_webview,container,false);
        }else if (getF().equals("MainActivityProgressBar")){
            return inflater.inflate(R.layout.f_ma_progressbar,container,false);
        }else if (getF().equals("Activity_MainProgressBar")){
            return inflater.inflate(R.layout.f_am_progressbar,container,false);
        }else if (getF().equals("MainActivityDateTime")){
            return inflater.inflate(R.layout.f_ma_datetime,container,false);
        }else if (getF().equals("Activity_MainDateTime")){
            return inflater.inflate(R.layout.f_am_datetime,container,false);
        }else {
            return inflater.inflate(R.layout.fragment_tabslayout,container,false);
        }
    }
    public String getF() {
        return F;
    }
}
