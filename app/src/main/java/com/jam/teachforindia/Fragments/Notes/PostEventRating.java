package com.jam.teachforindia.Fragments.Notes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Feedback;
import com.jam.teachforindia.RetroServices.ServiceResponses.ApplyForEvent.EventApplyResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.Feedback.FeedbackResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 09-02-2018.
 */

public class PostEventRating extends Fragment {

    String userid,eventid,name;
    TextView tv_name;
    EditText et_feedback;
    SeekBar sk_rating;
    ImageView iv_send;

    public PostEventRating() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_postevent_rating,container,false);

        userid = getArguments().getString("userid");
        eventid = getArguments().getString("eventid");
        name = getArguments().getString("name");

        sk_rating = v.findViewById(R.id.sk_rating);
        et_feedback = v.findViewById(R.id.et_feedback);
        tv_name = v.findViewById(R.id.tv_name);
        tv_name.setText("Hi " + name.split(" ")[0]);

        iv_send = v.findViewById(R.id.iv_send);
        iv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });
        return v;
    }

    private void sendFeedback() {
        Feedback f = RetroClient.getClient().create(Feedback.class);
        Call<FeedbackResponse> call = f.sendFeedback(userid,eventid, String.valueOf(sk_rating.getProgress()),et_feedback.getText().toString(),"");
        call.enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {

                if(response.body().getCode().equals("0")){
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
