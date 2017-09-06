package com.example.the.instacopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.data.PhotoData;

import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class PhotoAdapter extends ArrayAdapter<PhotoData>{

    Context mContext;
    List<PhotoData> mList;
    LayoutInflater inf;

    public PhotoAdapter(Context context, List<PhotoData> list) {
        super(context, R.layout.photo_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.photo_list_item, null);
        }

//        final PhotoData data = mList.get(position);
        return row;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
