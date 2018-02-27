package com.jam.teachforindia.Fragments.TopVolunteers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 26-02-2018.
 */

public class TopVolAdapter extends RecyclerView.Adapter<TopVolAdapter.MyVH>{

    ArrayList<TopVolPojo> topVols;

    public TopVolAdapter(ArrayList<TopVolPojo> topVols) {
        this.topVols = topVols;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_topvol,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {

        TopVolPojo tv = topVols.get(position);
        holder.tv_name.setText(tv.getFirstname());
        holder.tv_title.setText(tv.getTitle());
        holder.tv_score.setText(tv.getScore());

    }

    @Override
    public int getItemCount() {
        return topVols.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {

        TextView tv_name,tv_score,tv_title;

        public MyVH(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_score = itemView.findViewById(R.id.tv_score);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
