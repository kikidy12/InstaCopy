package com.example.the.instacopy;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.example.the.instacopy.utils.GlobalData;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(mContext, LoginActivity.class);
                startActivity(myIntent);
                finish();
            }
        }, 2000);

        GlobalData.initGlobalData();

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
