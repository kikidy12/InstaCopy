package com.example.the.instacopy.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.the.instacopy.R;

/**
 * Created by the on 2017-09-06.
 */

public class SearchSubFragment extends Fragment {

    SearchViewPageAdapter mSearchViewPageAdapter;

    private android.support.v4.view.ViewPager searchPager;
    private TextView underLine1;
    private TextView underLine2;
    private TextView underLine3;
    private TextView underLine4;
    private TextView populTxt;
    private TextView peopleTxt;
    private TextView tagTxt;
    private TextView placeTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search_sub, container, false);
        this.placeTxt = (TextView) v.findViewById(R.id.placeTxt);
        this.tagTxt = (TextView) v.findViewById(R.id.tagTxt);
        this.peopleTxt = (TextView) v.findViewById(R.id.peopleTxt);
        this.populTxt = (TextView) v.findViewById(R.id.populTxt);
        this.underLine4 = (TextView) v.findViewById(R.id.underLine4);
        this.underLine3 = (TextView) v.findViewById(R.id.underLine3);
        this.underLine2 = (TextView) v.findViewById(R.id.underLine2);
        this.underLine1 = (TextView) v.findViewById(R.id.underLine1);
        this.searchPager = (ViewPager) v.findViewById(R.id.searchPager);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setValues();
        setupEvents();

    }

    private void setupEvents() {

        searchPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    underLine1.setVisibility(View.VISIBLE);
                    populTxt.setTextColor(Color.parseColor("#000000"));
                    underLine2.setVisibility(View.GONE);
                    peopleTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine3.setVisibility(View.GONE);
                    tagTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine4.setVisibility(View.GONE);
                    placeTxt.setTextColor(Color.parseColor("#a0a0a0"));
                } else if (position == 1) {
                    underLine1.setVisibility(View.GONE);
                    populTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine2.setVisibility(View.VISIBLE);
                    peopleTxt.setTextColor(Color.parseColor("#000000"));
                    underLine3.setVisibility(View.GONE);
                    tagTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine4.setVisibility(View.GONE);
                    placeTxt.setTextColor(Color.parseColor("#a0a0a0"));
                } else if (position == 2) {
                    underLine1.setVisibility(View.GONE);
                    populTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine2.setVisibility(View.GONE);
                    peopleTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine3.setVisibility(View.VISIBLE);
                    tagTxt.setTextColor(Color.parseColor("#000000"));
                    underLine4.setVisibility(View.GONE);
                    placeTxt.setTextColor(Color.parseColor("#a0a0a0"));
                } else {
                    underLine1.setVisibility(View.GONE);
                    populTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine2.setVisibility(View.GONE);
                    peopleTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine3.setVisibility(View.GONE);
                    tagTxt.setTextColor(Color.parseColor("#a0a0a0"));
                    underLine4.setVisibility(View.VISIBLE);
                    placeTxt.setTextColor(Color.parseColor("#000000"));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        populTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(0);
            }
        });

        peopleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(1);
            }
        });

        tagTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(2);
            }
        });

        placeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(3);
            }
        });

        searchPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setValues() {
        mSearchViewPageAdapter = new SearchViewPageAdapter(getActivity().getSupportFragmentManager());
        searchPager.setAdapter(mSearchViewPageAdapter);
        searchPager.setCurrentItem(0);
    }

    public class SearchViewPageAdapter extends FragmentStatePagerAdapter {

        public SearchViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return new SearchPopFragment();
            }
            else if (position == 1) {
                return new SearchPeopleFragment();
            }
            else if (position == 2) {
                return new SearchTagFragment();
            }
            else {
                return new SearchPlaceFragment();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
