package com.jam.teachforindia.Fragments.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jam.teachforindia.Fragments.Notes.PostEventRating;
import com.jam.teachforindia.Fragments.Titles.TitlesFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetScore.ScoreResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Jam on 25-02-2018.
 */

public class Profile extends Fragment {

    SessionManager session;
    TextView tv_name,tv_title,tv_email,tv_score;
    ImageView iv_pp,iv_editicon;

    public Profile() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.fragment_profile,container,false);

        session = new SessionManager(getActivity());

        tv_name = v.findViewById(R.id.tv_name);
        tv_title = v.findViewById(R.id.tv_title);
        tv_email = v.findViewById(R.id.tv_email);
        tv_score = v.findViewById(R.id.tv_score);
        iv_pp = v.findViewById(R.id.iv_pp);
        iv_editicon = v.findViewById(R.id.iv_editicon);

        tv_name.setText(session.getUserDetails().get(SessionManager.NAME));

        if(session.getUsertitle() == null){
            tv_title.setText("the Good Student");
        }else{
            tv_title.setText(session.getUsertitle());
        }

        tv_email.setText(session.getUserDetails().get(SessionManager.USERNAME));


        if(session.getUserDetails().get(SessionManager.GENDER) != null && session.getUserDetails().get(SessionManager.GENDER).equals("Female")){
            Glide.with(getActivity()).load(R.drawable.girl_l).into(iv_pp);
        }else{
            Glide.with(getActivity()).load(R.drawable.boy_l).into(iv_pp);
        }

        if(!session.hideEditIconForever()){
            iv_editicon.setVisibility(View.VISIBLE);
        }

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTitlesPage();
            }
        });

        iv_editicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTitlesPage();
            }
        });

        getScore();

        return v;
    }

    private void getTitlesPage() {

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new TitlesFragment()).addToBackStack(null).commit();

    }


    private void getScore() {
        //tv_score;

        com.jam.teachforindia.RetroServices.ServiceInterfaces.Profile p = RetroClient.getClient().create(com.jam.teachforindia.RetroServices.ServiceInterfaces.Profile.class);
        Call<ScoreResponse> call = p.getScore(session.getUserId());
        call.enqueue(new Callback<ScoreResponse>() {
            @Override
            public void onResponse(Call<ScoreResponse> call, Response<ScoreResponse> response) {

                if(response.body().getCode().equals("0")){
                    tv_score.setText(response.body().getScore() + " units");
                    session.setUserScore(response.body().getScore());
                }
            }

            @Override
            public void onFailure(Call<ScoreResponse> call, Throwable t) {

            }
        });


    }

}
