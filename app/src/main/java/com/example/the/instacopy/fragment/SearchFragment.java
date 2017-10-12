package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.GlobalData;

/**
 * Created by one on 2017-09-05.
 */

public class SearchFragment extends Fragment {
    PhotoAdapter mPhotoAdapter;
    NewsfeedAdapter mNewsAdapet;

    private android.widget.EditText searchEdt;
    private GridView photoGridView2;
    private android.widget.FrameLayout searchSubFrgment;
    private android.widget.ImageView searchImg;
    private android.widget.ImageView backImg;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout searchLayout;
    private ImageView backBtn;
    private android.widget.LinearLayout tourLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search, container, false);
        this.tourLayout = (LinearLayout) v.findViewById(R.id.tourLayout);
        this.backBtn = (ImageView) v.findViewById(R.id.backBtn);
        this.searchLayout = (LinearLayout) v.findViewById(R.id.searchLayout);
        this.newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);
        this.backImg = (ImageView) v.findViewById(R.id.backImg);
        this.searchImg = (ImageView) v.findViewById(R.id.searchImg);
        this.searchSubFrgment = (FrameLayout) v.findViewById(R.id.searchSubFrgment);
        this.photoGridView2 = (GridView) v.findViewById(R.id.photoGridView2);
        this.searchEdt = (EditText) v.findViewById(R.id.searchEdt);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setValues();
        setupEvents();
    }

    private void setupEvents() {
        searchEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    photoGridView2.setVisibility(View.GONE);
                    searchSubFrgment.setVisibility(View.VISIBLE);
                    backImg.setVisibility(View.VISIBLE);
                    searchImg.setVisibility(View.GONE);
                }
                else {
                    searchEdt.setText("");
                }
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoGridView2.setVisibility(View.VISIBLE);
                searchSubFrgment.setVisibility(View.GONE);
                backImg.setVisibility(View.GONE);
                searchImg.setVisibility(View.VISIBLE);
                searchEdt.clearFocus();
            }
        });

        photoGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newsfeedListView.setVisibility(View.VISIBLE);
                photoGridView2.setVisibility(View.GONE);
                tourLayout.setVisibility(View.VISIBLE);
                searchLayout.setVisibility(View.GONE);
                newsfeedListView.smoothScrollToPosition(position);

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsfeedListView.setVisibility(View.GONE);
                photoGridView2.setVisibility(View.VISIBLE);
                tourLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            }
        });
    }


    private void setValues() {
        mNewsAdapet = new NewsfeedAdapter(getActivity(), GlobalData.photoDatas);
        mPhotoAdapter = new PhotoAdapter(getActivity(), GlobalData.photoDatas);
        photoGridView2.setAdapter(mPhotoAdapter);
        newsfeedListView.setAdapter(mNewsAdapet);
    }
    public void setsearchTxt(String str) {
        searchEdt.setHint(str);
    }

}
