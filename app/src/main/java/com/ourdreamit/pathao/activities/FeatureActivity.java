package com.ourdreamit.pathao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ourdreamit.pathao.R;

public class FeatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);
    }

    public void openLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openActivityLifeCycle(View view) {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    public void openLayoutBasics(View layoutView){
        Intent intent = new Intent(this, FeatureActivity.class);
        startActivity(intent);
    }

    public void openInternetDetector(View view) {
        Intent intent = new Intent(this, InternetDetector.class);
        startActivity(intent);
    }

    public void openAppResources(View view) {
        Intent intent = new Intent(this, AppResources.class);
        startActivity(intent);
    }
}