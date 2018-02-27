package com.jam.teachforindia.Fragments.StaffFeedback;

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

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.MyVH> {

    ArrayList<FeedbackPojo> feedbacks;

    public FeedbackAdapter(ArrayList<FeedbackPojo> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_feedback,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        FeedbackPojo f = feedbacks.get(position);
        holder.tv_feedback.setText(f.getFeedback());
    }

    @Override
    public int getItemCount() {
        return feedbacks.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_feedback;

        public MyVH(View itemView) {
            super(itemView);
            tv_feedback = itemView.findViewById(R.id.tv_feedbaack);
        }
    }
}
