package com.ourdreamit.pathao.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class CountingService extends Service {

    public static final String TAG = "CountingService";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Thread countThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startLongRunningOperation();
            }
        });
        countThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    private void startLongRunningOperation() {
        int i = 1;

        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "ticking: "+i);
            i++;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}