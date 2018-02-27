package com.jam.teachforindia.Fragments.Filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jam.teachforindia.Fragments.EventApplicants.EventApplicants;
import com.jam.teachforindia.Fragments.Notes.PostEventRating;
import com.jam.teachforindia.R;

/**
 * Created by Jam on 26-02-2018.
 */

public class FilterByFragment extends Fragment {

    TextView tv_gender,tv_age,tv_education;
    Button btn_filter;

    String sortby = null;

    public FilterByFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentfilter,container,false);

        tv_gender = v.findViewById(R.id.tv_gender);
        tv_age = v.findViewById(R.id.tv_age);
        tv_education = v.findViewById(R.id.tv_education);
        btn_filter = v.findViewById(R.id.btn_filter);


        tv_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortby = "gen";

                tv_gender.setTextColor(getResources().getColor(R.color.color_blue));
                tv_age.setTextColor(getResources().getColor(R.color.color_black));
                tv_education.setTextColor(getResources().getColor(R.color.color_black));
            }
        });

        tv_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortby = "age";

                tv_age.setTextColor(getResources().getColor(R.color.color_blue));
                tv_gender.setTextColor(getResources().getColor(R.color.color_black));
                tv_education.setTextColor(getResources().getColor(R.color.color_black));
            }
        });

        tv_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortby = "edu";

                tv_education.setTextColor(getResources().getColor(R.color.color_blue));
                tv_age.setTextColor(getResources().getColor(R.color.color_black));
                tv_gender.setTextColor(getResources().getColor(R.color.color_black));
            }
        });



        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment eve = new EventApplicants();
                Bundle b = new Bundle();
                b.putString("eventid",getArguments().getString("eventid"));
                b.putString("sortby",sortby);
                eve.setArguments(b);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                        .replace(R.id.container,eve)
                        .addToBackStack(null)
                        .commit();
            }
        });




        return v;
    }
}
