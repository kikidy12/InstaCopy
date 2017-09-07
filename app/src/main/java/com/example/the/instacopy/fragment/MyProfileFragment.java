package com.example.the.instacopy.fragment;

import android.app.AlertDialog;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.example.the.instacopy.MyProfileOptionActivity;
import com.example.the.instacopy.ProfileSettingActivity;
import com.example.the.instacopy.R;
import com.example.the.instacopy.adapter.NewsfeedAdapter;
import com.example.the.instacopy.adapter.PhotoAdapter;
import com.example.the.instacopy.utils.ContextUtil;
import com.example.the.instacopy.utils.GlobalData;
import com.example.the.instacopy.utils.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by the on 2017-09-06.
 */

public class MyProfileFragment extends Fragment {
    PhotoAdapter mPhotoAdapter;
    NewsfeedAdapter mNewsfeedAdapter;
    private int REQUEST_CODE_PICKER = 1;

    private de.hdodenhof.circleimageview.CircleImageView profileimage;
    private android.widget.GridView photoGridView;
    private android.widget.ImageView photoView;
    private android.widget.ImageView newsfeedView;
    private android.widget.ListView newsfeedListView;
    private android.widget.TextView idTxt;
    private android.widget.TextView nameTxt;
    private android.widget.LinearLayout photoViewFragment;
    private ImageView seeMoreBtn;
    private ImageView findPeopleImg;
    private TextView profileSettingTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_profile, container, false);
        this.profileSettingTxt = (TextView) v.findViewById(R.id.profileSettingTxt);
        this.findPeopleImg = (ImageView) v.findViewById(R.id.findPeopleImg);
        this.photoViewFragment = (LinearLayout) v.findViewById(R.id.photoViewFragment);
        this.nameTxt = (TextView) v.findViewById(R.id.nameTxt);
        this.idTxt = (TextView) v.findViewById(R.id.idTxt);
        this.newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);
        this.photoGridView = (GridView) v.findViewById(R.id.photoGridView);
        this.newsfeedView = (ImageView) v.findViewById(R.id.newsfeedView);
        this.photoView = (ImageView) v.findViewById(R.id.photoView);
        this.profileimage = (CircleImageView) v.findViewById(R.id.profile_image);
        this.seeMoreBtn = (ImageView) v.findViewById(R.id.seeMoreBtn);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setValues();
        setupEvents();
    }

    private void setupEvents() {

        profileSettingTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileSettingActivity.class);
                startActivity(intent);
            }
        });


        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("스토리에 추가");
                builder.setMessage("프로필 사진을 눌러 스토리에 사진과 동영상을 빠르게 추가할 수 있습니다.");
                builder.show();

            }
        });


        seeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyProfileOptionActivity.class);
                startActivity(intent);
            }
        });

        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoGridView.setVisibility(View.VISIBLE);
                newsfeedListView.setVisibility(View.GONE);
                photoViewFragment.setVisibility(View.GONE);
                photoView.setImageResource(R.drawable.ic_view_module_black_24dp);
                newsfeedView.setImageResource(R.drawable.ic_list_gray_24dp);
            }
        });
        newsfeedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoGridView.setVisibility(View.GONE);
                newsfeedListView.setVisibility(View.VISIBLE);
                photoViewFragment.setVisibility(View.GONE);
                photoView.setImageResource(R.drawable.ic_view_module_gray_24dp);
                newsfeedView.setImageResource(R.drawable.ic_list_black_24dp);
            }
        });

        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                photoGridView.setVisibility(View.GONE);
                newsfeedListView.setVisibility(View.GONE);
                photoViewFragment.setVisibility(View.VISIBLE);
            }
        });

        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void setValues() {
        mPhotoAdapter = new PhotoAdapter(getActivity(), GlobalData.photoDatas);
        photoGridView.setAdapter(mPhotoAdapter);
        mNewsfeedAdapter = new NewsfeedAdapter(getActivity(), GlobalData.newsfeedDatas);
        newsfeedListView.setAdapter(mNewsfeedAdapter);

        idTxt.setText(ContextUtil.getLoginUser(getActivity()).getUserId());
        nameTxt.setText(ContextUtil.getLoginUser(getActivity()).getName());
    }

    public void hidePhoto() {
        photoViewFragment.setVisibility(View.GONE);
        photoGridView.setVisibility(View.VISIBLE);
    }
}
