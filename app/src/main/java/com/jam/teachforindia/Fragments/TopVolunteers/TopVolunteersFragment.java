package com.jam.teachforindia.Fragments.TopVolunteers;

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
import com.jam.teachforindia.Fragments.Titles.TitlesAdapter;
import com.jam.teachforindia.Fragments.Titles.TitlesPojo;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.TopVolunteers;
import com.jam.teachforindia.RetroServices.ServiceResponses.TopVolunteers.TopVolResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.TopVolunteers.VolunteerData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 26-02-2018.
 */

public class TopVolunteersFragment extends Fragment{


    RecyclerView recyc_topvols;
    ArrayList<TopVolPojo> topvols;
    TopVolAdapter topVolAdapter;


    public TopVolunteersFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_topvolunteers,container,false);


        recyc_topvols = v.findViewById(R.id.recyc_topvols);
        topvols = new ArrayList<>();
        topVolAdapter = new TopVolAdapter(topvols);

        recyc_topvols.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_topvols.setItemAnimator(new DefaultItemAnimator());
        recyc_topvols.setAdapter(topVolAdapter);
        
        
        setVolunteerdata();


        return v;
    }

    private void setVolunteerdata() {

        TopVolunteers tpv = RetroClient.getClient().create(TopVolunteers.class);
        Call<TopVolResponse> call = tpv.getTopVolunteers();
        call.enqueue(new Callback<TopVolResponse>() {
            @Override
            public void onResponse(Call<TopVolResponse> call, Response<TopVolResponse> response) {

                if(response.body().getCode().equals("0")){

                    for(VolunteerData vd : response.body().getData()){
                        topvols.add(new TopVolPojo(vd.getFirstname(),vd.getUsertitle(),vd.getScore()));
                    }

                    topVolAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<TopVolResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
