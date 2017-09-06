package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.GlobalData;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by the on 2017-09-06.
 */

public class MyProfileFragment extends Fragment {
    PhotoAdapter mPhotoAdapter;
    NewsfeedAdapter mNewsfeedAdapter;

    private de.hdodenhof.circleimageview.CircleImageView profileimage;
    private android.widget.GridView photoGridView;
    private android.widget.ImageView photoView;
    private android.widget.ImageView newsfeedView;
    private android.widget.ListView newsfeedListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_profile, container, false);
        this.newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);
        this.newsfeedView = (ImageView) v.findViewById(R.id.newsfeedView);
        this.photoView = (ImageView) v.findViewById(R.id.photoView);
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
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoGridView.setVisibility(View.VISIBLE);
                newsfeedListView.setVisibility(View.GONE);
                photoView.setImageResource(R.drawable.ic_view_module_black_24dp);
                newsfeedView.setImageResource(R.drawable.ic_list_gray_24dp);
            }
        });
        newsfeedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoGridView.setVisibility(View.GONE);
                newsfeedListView.setVisibility(View.VISIBLE);
                photoView.setImageResource(R.drawable.ic_view_module_gray_24dp);
                newsfeedView.setImageResource(R.drawable.ic_list_black_24dp);
            }
        });
    }

    private void setValues() {
        mPhotoAdapter = new PhotoAdapter(getActivity(), GlobalData.photoDatas);
        photoGridView.setAdapter(mPhotoAdapter);
        mNewsfeedAdapter = new NewsfeedAdapter(getActivity(), GlobalData.newsfeedDatas);
        newsfeedListView.setAdapter(mNewsfeedAdapter);
    }
}
