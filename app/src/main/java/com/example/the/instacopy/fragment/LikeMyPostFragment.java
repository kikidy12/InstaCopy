package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NotificationAdapter;
import com.example.the.instacopy.utils.GlobalData;

/**
 * Created by the on 2017-09-06.
 */

public class LikeMyPostFragment extends Fragment {

    NotificationAdapter mNotificationAdapter;
    private android.widget.ListView myPostListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_post, container, false);
        this.myPostListView = (ListView) v.findViewById(R.id.myPostListView);
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
        mNotificationAdapter = new NotificationAdapter(getActivity(), GlobalData.NotidataList);
        myPostListView.setAdapter(mNotificationAdapter);
    }
}
