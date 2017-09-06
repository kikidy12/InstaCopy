package com.example.the.instacopy;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.the.instacopy.utils.GlobalData;

public class MainActivity extends BaseActivity {


    private ImageView homeBtn;
    private ImageView searchBtn;
    private ImageView likeBtn;
    private ImageView myProfileBtn;
    private android.widget.FrameLayout homeFragment;
    private android.widget.FrameLayout searchFragment;
    private android.widget.FrameLayout likeFragment;
    private android.widget.FrameLayout myProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        GlobalData.initGlobalData();

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment.setVisibility(View.VISIBLE);
                searchFragment.setVisibility(View.GONE);
                likeFragment.setVisibility(View.GONE);
                myProfileFragment.setVisibility(View.GONE);
                homeBtn.setImageResource(R.drawable.ic_home_black_24dp);
                searchBtn.setImageResource(R.drawable.ic_search_gray_24dp);
                likeBtn.setImageResource(R.drawable.heart_gray);
                myProfileBtn.setImageResource(R.drawable.ic_account_box_gray_24dp);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment.setVisibility(View.GONE);
                searchFragment.setVisibility(View.VISIBLE);
                likeFragment.setVisibility(View.GONE);
                myProfileFragment.setVisibility(View.GONE);
                homeBtn.setImageResource(R.drawable.ic_home_gray_24dp);
                searchBtn.setImageResource(R.drawable.ic_search_black_24dp);
                likeBtn.setImageResource(R.drawable.heart_gray);
                myProfileBtn.setImageResource(R.drawable.ic_account_box_gray_24dp);
            }
        });

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment.setVisibility(View.GONE);
                searchFragment.setVisibility(View.GONE);
                likeFragment.setVisibility(View.VISIBLE);
                myProfileFragment.setVisibility(View.GONE);
                homeBtn.setImageResource(R.drawable.ic_home_gray_24dp);
                searchBtn.setImageResource(R.drawable.ic_search_gray_24dp);
                likeBtn.setImageResource(R.drawable.heart_black);
                myProfileBtn.setImageResource(R.drawable.ic_account_box_gray_24dp);
            }
        });

        myProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment.setVisibility(View.GONE);
                searchFragment.setVisibility(View.GONE);
                likeFragment.setVisibility(View.GONE);
                myProfileFragment.setVisibility(View.VISIBLE);
                homeBtn.setImageResource(R.drawable.ic_home_gray_24dp);
                searchBtn.setImageResource(R.drawable.ic_search_gray_24dp);
                likeBtn.setImageResource(R.drawable.heart_gray);
                myProfileBtn.setImageResource(R.drawable.ic_account_box_black_24dp);
            }
        });
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
        this.myProfileFragment = (FrameLayout) findViewById(R.id.myProfileFragment);
        this.likeFragment = (FrameLayout) findViewById(R.id.likeFragment);
        this.searchFragment = (FrameLayout) findViewById(R.id.searchFragment);
        this.homeFragment = (FrameLayout) findViewById(R.id.homeFragment);
    }

}


