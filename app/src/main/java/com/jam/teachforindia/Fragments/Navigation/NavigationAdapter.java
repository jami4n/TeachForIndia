package com.jam.teachforindia.Fragments.Navigation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 22-02-2018.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyVH> {
    ArrayList<String> navigaitionlinks;
    LinkClicked linkClicked;

    public NavigationAdapter(ArrayList<String> navigaitionlinks, LinkClicked linkClicked) {
        this.navigaitionlinks = navigaitionlinks;
        this.linkClicked = linkClicked;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_navigation_item,parent,false);
        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(final MyVH holder, final int position) {
        final String link = navigaitionlinks.get(position);
        holder.tv_link.setText(link);
        holder.tv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkClicked.linkClicked(link,position,holder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return navigaitionlinks.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_link;

        public MyVH(View itemView) {
            super(itemView);
            tv_link = itemView.findViewById(R.id.tv_link);
        }
    }
}
