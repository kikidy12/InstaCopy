package com.example.the.instacopy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NotificationAdapter;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.datas.NotificationData;
import com.example.the.instacopy.utils.GlobalData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChoiJongHwan on 2017-09-06.
 */

public class LikeFragment extends Fragment {

    NotificationAdapter mNotificationAdapter;
    List<NotificationData> NotidataList = new ArrayList<>();

    private ListView myLikeListView;
    private TextView FollowingTxt;
    private TextView myPostTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_like, container, false);

        this.myPostTxt = (TextView) myView.findViewById(R.id.myPostTxt);
        this.FollowingTxt = (TextView) myView.findViewById(R.id.FollowingTxt);
        this.myLikeListView = (ListView) myView.findViewById(R.id.myLikeListView);


        return myView;
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
        mNotificationAdapter = new NotificationAdapter(getActivity(),NotidataList);
        myLikeListView.setAdapter(mNotificationAdapter);
    }

}
