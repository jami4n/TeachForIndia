package com.jam.teachforindia.Fragments.Events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 22-02-2018.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyVH> {

    ArrayList<EventsPojo> events;
    Context context;
    EventClicks eventClicks;

    public EventsAdapter(ArrayList<EventsPojo> events, Context context, EventClicks eventClicks) {
        this.events = events;
        this.context = context;
        this.eventClicks = eventClicks;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_event,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(final MyVH holder, int position) {
        final EventsPojo e = events.get(position);

        holder.tv_event_title.setText(e.getEventTitle());
        holder.tv_description.setText(e.getEventDescription());
        holder.tv_dates.setText(e.getEventStartDate());
        holder.tv_location.setText(e.getEventLocation());

        holder.btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventClicks.applyforevent(v,e.getEventId());
            }
        });

        holder.btn_more_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.ll_details.getVisibility() == View.VISIBLE){
                    holder.ll_details.setVisibility(View.GONE);
                }else{
                    holder.ll_details.setVisibility(View.VISIBLE);
                }
            }
        });

        Glide.with(context).load(e.getEventImage())
                .into(holder.iv_event_image);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_event_title,tv_description,tv_dates,tv_location;
        Button btn_apply,btn_more_details;
        ImageView iv_event_image;
        LinearLayout ll_details;

        public MyVH(View itemView) {
            super(itemView);

            tv_event_title = itemView.findViewById(R.id.tv_event_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_dates = itemView.findViewById(R.id.tv_dates);
            tv_location = itemView.findViewById(R.id.tv_location);
            btn_apply = itemView.findViewById(R.id.btn_apply);
            btn_more_details = itemView.findViewById(R.id.btn_more_details);
            iv_event_image = itemView.findViewById(R.id.iv_event_image);
            ll_details = itemView.findViewById(R.id.ll_details);

        }
    }
}
