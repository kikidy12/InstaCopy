package com.example.the.instacopy.adapter;

import android.content.Context;
import android.support.annotation.AnyRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by the on 2017-09-07.
 */

class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private final int resource;
    private Context context;
    private List<String> list;

    public TestAdapter(Context context, @AnyRes int resource, List<String> list) {
        this.resource = resource;
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(resource, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String item = getItem(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private String getItem(int position) {
        return list.get(position);
    }

    public void clear() {
        if(null != list) {
            list.clear();
        }
    }

    public void addAll(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View parent) {
            super(parent);

        }
    }
}