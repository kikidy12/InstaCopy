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
import android.widget.Toast;

import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.GlobalData;

/**
 * Created by one on 2017-09-05.
 */

public class SearchFragment extends Fragment {
    PhotoAdapter mPhotoAdapter;

    private android.widget.EditText searchEdt;
    private GridView photoGridView2;
    private android.widget.FrameLayout searchSubFrgment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search, container, false);
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
                }
            }
        });

        photoGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setValues() {
        mPhotoAdapter = new PhotoAdapter(getActivity(), GlobalData.photoDatas);
        photoGridView2.setAdapter(mPhotoAdapter);
    }
}
