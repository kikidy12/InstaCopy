package com.example.the.instacopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.the.instacopy.R;

/**
 * Created by the on 2017-09-06.
 */

public class photoViewFragment extends Fragment {

    private android.widget.ImageView backImg;
    private android.widget.ImageView imageView;
    private android.widget.ImageView imageView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_detail, container, false);
        this.imageView2 = (ImageView) v.findViewById(R.id.imageView2);
        this.imageView = (ImageView) v.findViewById(R.id.imageView);
        this.backImg = (ImageView) v.findViewById(R.id.backImg);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setValues();
        setupEvents();
    }

    private void setupEvents() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyProfileFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.myProfile)).hidePhoto();
            }
        });
    }

    private void setValues() {

    }

}
