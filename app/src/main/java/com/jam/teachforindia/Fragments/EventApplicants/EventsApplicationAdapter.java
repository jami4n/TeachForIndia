package com.jam.teachforindia.Fragments.EventApplicants;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 24-02-2018.
 */

public class EventsApplicationAdapter extends RecyclerView.Adapter<EventsApplicationAdapter.MyVH>{

    ArrayList<EventApplicantsPojo> eventApplicants;
    Context context;
    EventApplicantClicks eventApplicantClicks;

    public EventsApplicationAdapter(ArrayList<EventApplicantsPojo> eventApplicants, Context context, EventApplicantClicks eventApplicantClicks) {
        this.eventApplicants = eventApplicants;
        this.context = context;
        this.eventApplicantClicks = eventApplicantClicks;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_event_applicant,parent,false);
        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(final MyVH holder, int position) {

        final EventApplicantsPojo e = eventApplicants.get(position);

        holder.tv_name.setText(e.getName());
        holder.tv_score.setText(e.getScore());
        holder.tv_details.setText(e.getGender() + ", " + e.getAge());
        holder.tv_education.setText(e.getEducation());
        holder.tv_edu_details.setText(e.getEducationDetails());
        holder.tv_org_details.setText(e.getOrganisationDetails());
        holder.tv_skills.setText(e.getSkillSets());
        holder.tv_application_note.setText(e.getApplicationNote());

        String selected = "";

        if(e.getIsSelected().equals("0")){
            selected = "New Applicant";
        }else if(e.getIsSelected().equals("1")){
            selected = "Selected";
        }else if(e.getIsSelected().equals("2")){
            selected = "On Hold";
        }else if(e.getIsSelected().equals("3")){
            selected = "Not Selected";
        }

        holder.tv_status.setText(selected);

        holder.btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.ll_details.getVisibility() == View.VISIBLE){
                    holder.ll_details.setVisibility(View.GONE);
                }else{
                    holder.ll_details.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventApplicantClicks.onSelectedClicked(v,1,e.getApplicationId(),e.getName());
            }
        });


        holder.btn_hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventApplicantClicks.onSelectedClicked(holder.tv_status,2,e.getApplicationId(),e.getName());
            }
        });


        holder.btn_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventApplicantClicks.onSelectedClicked(v,3,e.getApplicationId(),e.getName());
            }
        });


    }

    @Override
    public int getItemCount() {
        return eventApplicants.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_name,tv_score,tv_details,tv_education,
                tv_edu_details,tv_org_details,tv_skills,
                tv_application_note,tv_status;
        LinearLayout ll_details;
        Button btn_details;
        ImageView btn_select,btn_reject,btn_hold;

        public MyVH(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_score = itemView.findViewById(R.id.tv_score);
            tv_details = itemView.findViewById(R.id.tv_details);
            tv_education = itemView.findViewById(R.id.tv_education);
            tv_edu_details = itemView.findViewById(R.id.tv_edu_details);
            tv_org_details = itemView.findViewById(R.id.tv_org_details);
            tv_skills = itemView.findViewById(R.id.tv_skills);
            tv_application_note = itemView.findViewById(R.id.tv_application_note);
            tv_status = itemView.findViewById(R.id.tv_status);
            ll_details = itemView.findViewById(R.id.ll_details);
            btn_select = itemView.findViewById(R.id.iv_select);
            btn_reject = itemView.findViewById(R.id.iv_reject);
            btn_hold = itemView.findViewById(R.id.iv_hold);
            btn_details = itemView.findViewById(R.id.btn_details);
        }
    }
}
