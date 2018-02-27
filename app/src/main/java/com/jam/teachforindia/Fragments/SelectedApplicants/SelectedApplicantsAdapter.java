package com.jam.teachforindia.Fragments.SelectedApplicants;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jam.teachforindia.Fragments.EventApplicants.EventApplicantClicks;
import com.jam.teachforindia.Fragments.EventApplicants.EventApplicantsPojo;
import com.jam.teachforindia.Fragments.EventApplicants.EventsApplicationAdapter;
import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 25-02-2018.
 */

public class SelectedApplicantsAdapter extends RecyclerView.Adapter<SelectedApplicantsAdapter.MyVH> {

    ArrayList<EventApplicantsPojo> eventApplicants;
    Context context;
    SelectedApplicantsClick selectedApplicantsClick;


    public SelectedApplicantsAdapter(ArrayList<EventApplicantsPojo> eventApplicants, Context context, SelectedApplicantsClick selectedApplicantsClick) {
        this.eventApplicants = eventApplicants;
        this.context = context;
        this.selectedApplicantsClick = selectedApplicantsClick;
    }


    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_selected_applicant,parent,false);
        return new SelectedApplicantsAdapter.MyVH(v);
    }

    @Override
    public void onBindViewHolder(final MyVH holder, int position) {

        final EventApplicantsPojo e = eventApplicants.get(position);

        holder.tv_name.setText(e.getName());
        holder.iv_allot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedApplicantsClick.selectedApplicantAllot(e.getUserId(),e.getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventApplicants.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {

        TextView tv_name;
        ImageView iv_allot;

        public MyVH(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            iv_allot = itemView.findViewById(R.id.iv_allot);

        }
    }
}
