package com.jam.teachforindia.Fragments.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jam.teachforindia.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Jam on 22-02-2018.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyVH> {

    ArrayList<BannerPojo> banners = new ArrayList<>();
    Context context;

    public BannerAdapter(ArrayList<BannerPojo> banners, Context context) {
        this.banners = banners;
        this.context = context;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_home_banner,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        BannerPojo b = banners.get(position);

        RequestOptions r = new RequestOptions();
        r.centerInside();

        Log.d(TAG, "onBindViewHolder: " + b.getBannerpath());

        Glide.with(context)
            .load(b.getBannerpath())
            .into(holder.iv_banner);

        holder.tv_banner_text.setText(b.getBannerdescription());
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        ImageView iv_banner;
        TextView tv_banner_text;

        public MyVH(View itemView) {
            super(itemView);

            iv_banner = itemView.findViewById(R.id.iv_banner);
            tv_banner_text = itemView.findViewById(R.id.tv_banner_text);
        }
    }
}
