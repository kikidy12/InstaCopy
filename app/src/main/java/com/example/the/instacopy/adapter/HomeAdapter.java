package com.example.the.instacopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.the.instacopy.R;
import com.example.the.instacopy.data.HomeData;

import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class HomeAdapter extends ArrayAdapter<HomeData> {

    Context mContext;
    List<HomeData> mList;
    LayoutInflater inf;

    public HomeAdapter(Context context, List<HomeData> list) {
        super(context, R.layout.home_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.home_list_item, null);
        }
        return row;
    }

    @Override
    public int getCount() {
        return 15;
    }
}
