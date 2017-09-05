package com.example.the.instacopy;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.GlobalData;

public class SearchActivity extends BaseActivity {

    private PhotoAdapter mPhotoAdapter;

    private android.widget.EditText searchEdt;
    private android.widget.ListView photoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mPhotoAdapter = new PhotoAdapter(mContext, GlobalData.photoDatas);
        photoListView.setAdapter(mPhotoAdapter);
    }

    @Override
    public void bindViews() {
        this.photoListView = (ListView) findViewById(R.id.photoListView);
        this.searchEdt = (EditText) findViewById(R.id.searchEdt);
    }
}
