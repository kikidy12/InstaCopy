package com.example.the.instacopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.the.instacopy.adapter.HomeAdapter;
import com.example.the.instacopy.data.HomeData;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private android.widget.ListView homeListView;
    List<HomeData> homeDataList = new ArrayList<>();
    HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mHomeAdapter = new HomeAdapter(mContext, homeDataList);
        homeListView.setAdapter(mHomeAdapter);
    }

    @Override
    public void bindViews() {
        this.homeListView = (ListView) findViewById(R.id.homeListView);
    }
}
