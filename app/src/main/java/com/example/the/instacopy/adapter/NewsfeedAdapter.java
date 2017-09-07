package com.example.the.instacopy.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.the.instacopy.R;
import com.example.the.instacopy.ReplyActivity;
import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.utils.GlobalData;

import java.util.List;
import java.util.Locale;

/**
 * Created by the on 2017-09-05.
 */

public class NewsfeedAdapter extends ArrayAdapter<NewsfeedData> {

    Context mContext;
    List<NewsfeedData> mList;
    LayoutInflater inf;
    String[] seemore = {"보관","공유하기","수정","삭제","댓글기능해제","공유URL복사"};
    boolean isheart = false;

    public NewsfeedAdapter(Context context, List<NewsfeedData> list) {
        super(context, R.layout.newsfeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.newsfeed_list_item, null);
        }

        NewsfeedData data = mList.get(position);

        ImageView replyImg = (ImageView) row.findViewById(R.id.replyImg);
        ImageView seeMoreBtn = (ImageView) row.findViewById(R.id.seeMoreBtn);
        TextView idTxt = (TextView) row.findViewById(R.id.idTxt);
        TextView IDTxt = (TextView) row.findViewById(R.id.IDTxt);
        TextView likeCountTxt = (TextView) row.findViewById(R.id.likeCountTxt);
        final ImageView heartImg = (ImageView) row.findViewById(R.id.heartImg);

        idTxt.setText(data.getWriter().getName());
        IDTxt.setText(data.getWriter().getName());
        String likeStr = String.format(Locale.KOREA, "%d개", data.getLikeCount());
        likeCountTxt.setText(likeStr);

        seeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setItems(seemore, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        heartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isheart) {
                    heartImg.setImageResource(R.drawable.heart_black);
                    Toast.makeText(mContext, "좋아요를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                    isheart=true;
                }
                else {
                    heartImg.setImageResource(R.drawable.empty_heart);
                    isheart=false;
                }
            }
        });
        replyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyActivity.class);
                mContext.startActivity(intent);
            }
        });

        return row;
    }
}