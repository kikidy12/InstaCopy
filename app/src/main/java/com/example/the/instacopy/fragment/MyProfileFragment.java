package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.GlobalData;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by the on 2017-09-06.
 */

public class MyProfileFragment extends Fragment {
    PhotoAdapter mPhotoAdapter;

    private de.hdodenhof.circleimageview.CircleImageView profileimage;
    private android.widget.GridView photoGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_profile, container, false);
        this.photoGridView = (GridView) v.findViewById(R.id.photoGridView);
        this.profileimage = (CircleImageView) v.findViewById(R.id.profile_image);

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
        mPhotoAdapter = new PhotoAdapter(getActivity(), GlobalData.photoDatas);
        photoGridView.setAdapter(mPhotoAdapter);
    }
}
