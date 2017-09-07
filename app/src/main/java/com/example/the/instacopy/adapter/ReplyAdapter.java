package com.example.the.instacopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.data.ReplyData;

import java.util.List;

/**
 * Created by the on 2017-09-07.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {

    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;

    public ReplyAdapter(Context context, List<ReplyData> list) {
        super(context, R.layout.reply_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        ReplyData data = mList.get(position);


        return row;
    }

    @Override
    public int getCount() {
        return 20;
    }
}

