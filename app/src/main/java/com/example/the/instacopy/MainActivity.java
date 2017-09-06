package com.example.the.instacopy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {


    private ImageView homeBtn;
    private ImageView searchBtn;
    private ImageView likeBtn;
    private ImageView myProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
    }

    @Override
    public void setValues() {

    }


    @Override
    public void bindViews() {
        this.myProfileBtn = (ImageView) findViewById(R.id.myProfileBtn);
        this.likeBtn = (ImageView) findViewById(R.id.likeBtn);
        this.searchBtn = (ImageView) findViewById(R.id.searchBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
    }

}


