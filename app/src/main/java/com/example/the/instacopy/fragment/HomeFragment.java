package com.example.the.instacopy.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.GlobalData;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by the on 2017-09-06.
 */

public class HomeFragment extends Fragment {

    private android.widget.ListView homeListView;
    NewsfeedAdapter mHomeAdapter;
    private android.support.v7.widget.RecyclerView listview;
    final int REQ_FOR_GALLERY=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        this.listview = (RecyclerView) v.findViewById(R.id.list_view);
        this.homeListView = (ListView) v.findViewById(R.id.homeListView);

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
        mHomeAdapter = new NewsfeedAdapter(getActivity(), GlobalData.newsfeedDatas);
        homeListView.setAdapter(mHomeAdapter);

    }

}
