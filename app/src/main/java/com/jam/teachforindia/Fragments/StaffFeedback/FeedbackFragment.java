package com.jam.teachforindia.Fragments.StaffFeedback;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Events.EventsAdapter;
import com.jam.teachforindia.Fragments.Events.EventsPojo;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Feedback;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback.FeedbackResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback.StaffFeedbackData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Jam on 26-02-2018.
 */

public class FeedbackFragment extends Fragment {


    RecyclerView recyc_feedback;
    FeedbackAdapter feedbackAdapter;
    ArrayList<FeedbackPojo> feedbacks;


    public FeedbackFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feedback,container,false);

        recyc_feedback = v.findViewById(R.id.recyc_feedback);
        feedbacks = new ArrayList<>();
        feedbackAdapter = new FeedbackAdapter(feedbacks);

        recyc_feedback.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_feedback.setItemAnimator(new DefaultItemAnimator());
        recyc_feedback.setAdapter(feedbackAdapter);

        setFeedbacks();

        return v;
    }

    private void setFeedbacks() {

        Feedback f = RetroClient.getClient().create(Feedback.class);
        Call<FeedbackResponse> call = f.getStaffFeedback();
        call.enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {

                if(response.body().getCode().equals("0")){

                    for (StaffFeedbackData sf : response.body().getData()){
                        feedbacks.add(new FeedbackPojo(sf.getStafffeedbackid(),sf.getFeedback(),sf.getAuthorid()));
                    }

                    feedbackAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
