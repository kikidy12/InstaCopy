package com.example.the.instacopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.the.instacopy.R;

/**
 * Created by the on 2017-09-06.
 */

public class SearchSubFragment extends Fragment {

    SearchViewPageAdapter mSearchViewPageAdapter;

    private android.support.v4.view.ViewPager searchPager;
    private android.widget.ImageView populTag;
    private android.widget.ImageView peopleTag;
    private android.widget.ImageView tagTag;
    private android.widget.ImageView placeTag;
    private android.widget.LinearLayout peopleLayout;
    private android.widget.LinearLayout tagLayout;
    private android.widget.LinearLayout placeLayout;
    private android.widget.LinearLayout populLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search_sub, container, false);
        this.populLayout = (LinearLayout) v.findViewById(R.id.populLayout);
        this.placeLayout = (LinearLayout) v.findViewById(R.id.placeLayout);
        this.tagLayout = (LinearLayout) v.findViewById(R.id.tagLayout);
        this.peopleLayout = (LinearLayout) v.findViewById(R.id.peopleLayout);
        this.placeTag = (ImageView) v.findViewById(R.id.placeTag);
        this.tagTag = (ImageView) v.findViewById(R.id.tagTag);
        this.peopleTag = (ImageView) v.findViewById(R.id.peopleTag);
        this.populTag = (ImageView) v.findViewById(R.id.populTag);
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
                    populLayout.setBackgroundResource(R.color.black);
                    peopleLayout.setBackgroundResource(R.color.white);
                    tagLayout.setBackgroundResource(R.color.white);
                    placeLayout.setBackgroundResource(R.color.white);
                } else if (position == 1) {
                    populLayout.setBackgroundResource(R.color.white);
                    peopleLayout.setBackgroundResource(R.color.black);
                    tagLayout.setBackgroundResource(R.color.white);
                    placeLayout.setBackgroundResource(R.color.white);
                } else if (position == 2) {
                    populLayout.setBackgroundResource(R.color.white);
                    peopleLayout.setBackgroundResource(R.color.white);
                    tagLayout.setBackgroundResource(R.color.black);
                    placeLayout.setBackgroundResource(R.color.white);
                } else {
                    populLayout.setBackgroundResource(R.color.white);
                    peopleLayout.setBackgroundResource(R.color.white);
                    tagLayout.setBackgroundResource(R.color.white);
                    placeLayout.setBackgroundResource(R.color.black);
                }
            }
//          dasda
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        populTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(0);
            }
        });

        peopleTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(1);
            }
        });

        tagTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPager.setCurrentItem(2);
            }
        });

        placeTag.setOnClickListener(new View.OnClickListener() {
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
