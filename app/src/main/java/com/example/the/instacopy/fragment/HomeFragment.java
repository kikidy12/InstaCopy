package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.utils.GlobalData;

/**
 * Created by the on 2017-09-06.
 */

public class HomeFragment extends Fragment {

    private android.widget.ListView homeListView;
    NewsfeedAdapter mHomeAdapter;
    private android.support.v7.widget.RecyclerView listview;

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
