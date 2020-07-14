package com.ourdreamit.pathao.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ourdreamit.pathao.R;

public class InternetDetector extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView internet_tv;
    private IntentFilter intentFilter;

    private BroadcastReceiver internetReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(checkInternet(context)){
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                internet_tv.setText("Hurray, You are connected.");
            }else{
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.VISIBLE);
                internet_tv.setText("Please Connect Internet");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_detector);

        progressBar = findViewById(R.id.progressBar);
        internet_tv = findViewById(R.id.internet_tv);

    }

    boolean checkInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Broadcast Receiver
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(internetReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(internetReceiver);
    }
}
