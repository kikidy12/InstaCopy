package com.example.the.instacopy.fragment;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.the.instacopy.R;

/**
 * Created by ChoiJongHwan on 2017-09-06.
 */

public class LikeFragment extends Fragment {

    LikeViewPageAdapter mLikeAdapter;

    private TextView FollowingTxt;
    private TextView myPostTxt;
    private TextView followingUnder;
    private TextView likeUnder;
    private android.support.v4.view.ViewPager myLikeListViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_like, container, false);

        this.myLikeListViewPager = (ViewPager) myView.findViewById(R.id.myLikeListViewPager);
        this.likeUnder = (TextView) myView.findViewById(R.id.likeUnder);
        this.followingUnder = (TextView) myView.findViewById(R.id.followingUnder);
        this.myPostTxt = (TextView) myView.findViewById(R.id.myPostTxt);
        this.FollowingTxt = (TextView) myView.findViewById(R.id.FollowingTxt);

        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
        setupEvents();
    }

    private void setupEvents() {

        myLikeListViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==0) {
                    FollowingTxt.setTextColor(Color.parseColor("#5DA1E0"));
                    followingUnder.setVisibility(View.VISIBLE);
                    myPostTxt.setTextColor(Color.parseColor("#000000"));
                    likeUnder.setVisibility(View.GONE);
                }

                else {
                    myPostTxt.setTextColor(Color.parseColor("#5DA1E0"));
                    likeUnder.setVisibility(View.VISIBLE);
                    FollowingTxt.setTextColor(Color.parseColor("#000000"));
                    followingUnder.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        FollowingTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myLikeListViewPager.setCurrentItem(0);
            }
        });

        myPostTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLikeListViewPager.setCurrentItem(1);
            }
        });

    }

    private void setValues() {
        mLikeAdapter = new LikeViewPageAdapter(getActivity().getSupportFragmentManager());
        myLikeListViewPager.setAdapter(mLikeAdapter);
        myLikeListViewPager.setCurrentItem(0);
    }

    public class LikeViewPageAdapter extends FragmentStatePagerAdapter {

        public LikeViewPageAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return new FollowingFragment();
            }
            else {
                return new LikeMyPostFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
