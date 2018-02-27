package com.jam.teachforindia.Fragments.Titles;

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
import com.jam.teachforindia.Fragments.Profile.Profile;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Titles;
import com.jam.teachforindia.RetroServices.ServiceResponses.SetTitles.SetTitlesResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.Titles.TitlesData;
import com.jam.teachforindia.RetroServices.ServiceResponses.Titles.TitlesResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 26-02-2018.
 */

public class TitlesFragment extends Fragment implements TitlesClick{

    RecyclerView recyc_titles;
    ArrayList<TitlesPojo> titles;
    TitlesAdapter titlesAdapter;

    SessionManager session;

    public TitlesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_titles,container,false);

        recyc_titles = v.findViewById(R.id.recyc_titles);
        titles = new ArrayList<>();
        titlesAdapter = new TitlesAdapter(titles,this);

        recyc_titles.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_titles.setItemAnimator(new DefaultItemAnimator());
        recyc_titles.setAdapter(titlesAdapter);

        session = new SessionManager(getActivity());

        getTitles();

        return v;
    }

    private void getTitles() {

        final Titles t = RetroClient.getClient().create(Titles.class);
        Call<TitlesResponse> call = t.getTitles(session.getUserScore());
        call.enqueue(new Callback<TitlesResponse>() {
            @Override
            public void onResponse(Call<TitlesResponse> call, Response<TitlesResponse> response) {

                if(response.body().getCode().equals("0")){

                    for(TitlesData td : response.body().getTitles()){
                        titles.add(new TitlesPojo(td.getTitleid(),td.getTitle()));
                    }

                    titlesAdapter.notifyDataSetChanged();

                }else{
                    Toast.makeText(getActivity(), "" +response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TitlesResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void titleClicked(String titleid, String title) {

        Titles t = RetroClient.getClient().create(Titles.class);
        Call<SetTitlesResponse> call = t.setTitles(session.getUserId(),title);
        call.enqueue(new Callback<SetTitlesResponse>() {
            @Override
            public void onResponse(Call<SetTitlesResponse> call, Response<SetTitlesResponse> response) {

                if(response.body().getCode().equals("0")){
                    session.setUserTitle(response.body().getData());
                    session.hideEditIconForever(true);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new Profile()).addToBackStack(null).commit();
                }
            }

            @Override
            public void onFailure(Call<SetTitlesResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
