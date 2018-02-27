package com.jam.teachforindia.Fragments.Titles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 26-02-2018.
 */

public class TitlesAdapter extends RecyclerView.Adapter<TitlesAdapter.MyVH>{

    ArrayList<TitlesPojo> titles;
    TitlesClick titlesClick;

    public TitlesAdapter(ArrayList<TitlesPojo> titles, TitlesClick titlesClick) {
        this.titles = titles;
        this.titlesClick = titlesClick;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_title,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        final TitlesPojo t = titles.get(position);
        holder.tv_title.setText(t.getTitle());
        holder.ll_titleholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titlesClick.titleClicked(t.getTitleid(),t.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_title;
        LinearLayout ll_titleholder;

        public MyVH(View itemView) {
            super(itemView);

            ll_titleholder = itemView.findViewById(R.id.ll_titleholder);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
