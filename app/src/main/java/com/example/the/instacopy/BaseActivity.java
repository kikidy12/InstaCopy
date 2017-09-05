package com.example.the.instacopy;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-09-05.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();

}
