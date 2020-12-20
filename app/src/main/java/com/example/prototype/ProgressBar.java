package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class ProgressBar extends AppCompatActivity {
    Button btnProgress;
    ProgressDialog progressBar;
    private int progressBarStatus=0;
    private Handler progressBarHandler=new Handler();
    private long fileSize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        btnProgress=findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar=new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("File Downloading...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();

                //reset progress bar status
                progressBarStatus=0;
                //reset filesize
                fileSize=0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressBarStatus<100){
                            progressBarStatus = doSomeTask();
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        if (progressBarStatus >= 100){
                            try {
                                Thread.sleep(2000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressBar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }
    public int doSomeTask(){
        while (fileSize<=1000000){
            fileSize++;
            if (fileSize==100000){
                return 10;
            }else if (fileSize==200000){
                return 20;
            }else if (fileSize==300000){
                return 30;
            }
        }
        return 100;
    }
}