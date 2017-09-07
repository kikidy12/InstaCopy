package com.example.the.instacopy;

import android.os.Bundle;
import android.widget.TextView;

public class MyProfileOptionActivity extends BaseActivity {

    private android.widget.TextView textView;
    private android.widget.TextView idPlusTxt;
    private android.widget.TextView LogoutTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_option);

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
        this.LogoutTxt = (TextView) findViewById(R.id.LogoutTxt);
        this.idPlusTxt = (TextView) findViewById(R.id.idPlusTxt);
    }
}
