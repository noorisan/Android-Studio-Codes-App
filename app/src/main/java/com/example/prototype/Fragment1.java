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
            return inflater.inflate(R.layout.fragment_tabslayout,container,false);
        }else if (getF().equals("MainActivitySpinner")){
            return inflater.inflate(R.layout.fragment_tabslayout2,container,false);
        }else if (getF().equals("Noor")){
            return inflater.inflate(R.layout.fragment_tabslayout2,container,false);
        }else {
            return inflater.inflate(R.layout.fragment_tabslayout,container,false);
        }
    }

    public String getF() {
        return F;
    }
}
