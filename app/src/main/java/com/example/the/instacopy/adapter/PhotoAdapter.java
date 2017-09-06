package com.example.the.instacopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.the.instacopy.R;
import com.example.the.instacopy.data.NewsfeedData;

import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class PhotoAdapter extends ArrayAdapter<NewsfeedData>{

    Context mContext;
    List<NewsfeedData> mList;
    LayoutInflater inf;
    int[] dogs = {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3};

    public PhotoAdapter(Context context, List<NewsfeedData> list) {
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

//        NewsfeedData data = mList.get(position);

        ImageView photoImg = (ImageView) row.findViewById(R.id.photoImg);
        photoImg.setImageResource(dogs[position%3]);
//        Glide.with(mContext).load(data.getImageURL()).into(photoImg);

        return row;
    }
}
