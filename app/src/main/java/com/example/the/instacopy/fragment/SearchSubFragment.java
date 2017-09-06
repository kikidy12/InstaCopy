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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_search_sub, container, false);
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

        mSearchViewPageAdapter = new SearchViewPageAdapter(getActivity().getSupportFragmentManager());

    }

    public class SearchViewPageAdapter extends FragmentStatePagerAdapter {

        public SearchViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position==0) {

            }
            else if (position==1) {

            }
            else if (position==2) {
                return new SearchTagFragment();
            }
            else {
                return new SearchPlaceFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
