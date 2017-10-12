package com.example.the.instacopy.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.the.instacopy.R;
import com.example.the.instacopy.ReplyActivity;
import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.data.User;
import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.GlobalData;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

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

        final NewsfeedData data = mList.get(position);

        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        ImageView replyImg = (ImageView) row.findViewById(R.id.replyImg);
        ImageView seeMoreBtn = (ImageView) row.findViewById(R.id.seeMoreBtn);
        TextView idTxt = (TextView) row.findViewById(R.id.idTxt);
        final TextView IDTxt = (TextView) row.findViewById(R.id.IDTxt);
        final TextView likeCountTxt = (TextView) row.findViewById(R.id.likeCountTxt);
        TextView contentTxt = (TextView)row.findViewById(R.id.contentTxt);
        final ImageView heartImg = (ImageView) row.findViewById(R.id.heartImg);

        idTxt.setText(data.getWriter().getName());
        IDTxt.setText(data.getWriter().getUserId());
        String likeStr = String.format(Locale.KOREA, "%d개", data.getLikeUsers().size());
        Glide.with(mContext).load("http://13.125.2.51/" + data.getImageURL()).into(imageView);
        likeCountTxt.setText(data.getLikeUsers().size()+"개");
        contentTxt.setText(data.getContent());

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

                ServerUtil.like_or_unlike(mContext, ContextUtil.getLoginUser(mContext).getId(), data.getNewsfeedId(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                data.getLikeUsers().add(ContextUtil.getLoginUser(mContext));
                            }
                            else {
                                data.getLikeUsers().remove(ContextUtil.getLoginUser(mContext));
                            }

                            notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        replyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyActivity.class);
                mContext.startActivity(intent);
            }
        });

        if (data.getLikeUsers().contains(ContextUtil.getLoginUser(mContext))) {
            heartImg.setImageResource(R.drawable.heart_black);
        }
        else {
            heartImg.setImageResource(R.drawable.empty_heart);
        }

        return row;
    }

    private void settingLikeToServer() {

    }

}