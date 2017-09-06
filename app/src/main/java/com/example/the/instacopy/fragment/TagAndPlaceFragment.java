package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.the.instacopy.R;

/**
 * Created by the on 2017-09-06.
 */

public class TagAndPlaceFragment extends Fragment {

    private android.widget.TextView tab1;
    private android.widget.TextView tab2;
    private android.support.v4.view.ViewPager searchViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tag_place, container, false);
        this.searchViewPager = (ViewPager) v.findViewById(R.id.searchViewPager);
        this.tab2 = (TextView) v.findViewById(R.id.tab2);
        this.tab1 = (TextView) v.findViewById(R.id.tab1);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setValues();
        setupEvents();
    }

    private void setupEvents() {

    }

    private void setValues() {

    }
}
