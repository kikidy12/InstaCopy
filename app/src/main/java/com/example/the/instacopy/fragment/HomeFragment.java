package com.example.the.instacopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.the.instacopy.NewsFeedDetailActivity;
import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-06.
 */

public class HomeFragment extends Fragment {

    List<NewsfeedData> mNewsfeedDataList = new ArrayList<>();
    private android.widget.ListView homeListView;
    NewsfeedAdapter mHomeAdapter;
    private android.support.v7.widget.RecyclerView listview;
    final int REQ_FOR_GALLERY = 1;
    private android.widget.ImageView imageView3;
    private android.support.v4.widget.SwipeRefreshLayout swipLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        this.swipLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipLayout);
        this.imageView3 = (ImageView) v.findViewById(R.id.imageView3);
        this.listview = (RecyclerView) v.findViewById(R.id.list_view);
        this.homeListView = (ListView) v.findViewById(R.id.homeListView);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
        setupEvents();
    }

    private void setupEvents() {
        // 당겨서 새로고침이 발생할 때 서버에서 다시 데이터를 받아와 보여준다.
        swipLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                swipLayout.setRefreshing(false);
            }
        });
    }

    // 전체 뉴스피드를 서버에서 받아온다.
    private void getData() {
        ServerUtil.get_all_newfeeds(getActivity(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    mNewsfeedDataList.clear();
                    JSONArray arrays = json.getJSONArray("newsfeeds");
                    for (int i = arrays.length()-1; i >= 0; i--) {
                        mNewsfeedDataList.add(NewsfeedData.getNewsfeedFromJsonObject(arrays.getJSONObject(i)));
                    }
                    mHomeAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setValues() {
        mHomeAdapter = new NewsfeedAdapter(getActivity(), mNewsfeedDataList);
        homeListView.setAdapter(mHomeAdapter);
        getData();
    }

}
