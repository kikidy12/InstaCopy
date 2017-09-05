package com.example.the.instacopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.the.instacopy.R;
import com.example.the.instacopy.datas.NotificationData;

import java.util.List;
import java.util.Locale;

/**
 * Created by the on 2017-09-05.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationData> {



    Context mContext;
    List<NotificationData> mList;
    LayoutInflater inf;

    public NotificationAdapter(Context context, List<NotificationData> list) {
        super(context, R.layout.my_noti_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.my_noti_list_item, null);
        }
//
//        NotificationData data = mList.get(position);
//
//        TextView notiTxt = (TextView) row.findViewById(R.id.notiTxt);
//
//
//        String notiTxtStr = "";
//
//        if (data.getActionType().equals("like")) {
//            notiTxtStr = String.format(Locale.KOREA, "%s님이 게시물을 좋아합니다.",
//                    data.getActor().getNickName());
////            %d => int
////            %f => double, float
////            %s => String
//
////            notiTxtStr = data.getActor().getNickName()+"님이 게시글을 좋아합니다.";
//
//        }
//        else if (data.getActionType().equals("reply")) {
//            notiTxtStr = String.format(Locale.KOREA, "%s님이 게시물에 댓글을 남겼습니다.",
//                    data.getActor().getNickName());
//        }

//        notiTxt.setText(notiTxtStr);


        return row;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
