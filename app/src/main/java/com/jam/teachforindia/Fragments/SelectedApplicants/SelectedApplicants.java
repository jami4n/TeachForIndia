package com.jam.teachforindia.Fragments.SelectedApplicants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.EventApplicants.EventApplicantsPojo;
import com.jam.teachforindia.Fragments.EventApplicants.EventsApplicationAdapter;
import com.jam.teachforindia.Fragments.Notes.PostEventRating;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.ApplicantData;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.EventApplicantsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 25-02-2018.
 */

public class SelectedApplicants extends Fragment implements SelectedApplicantsClick{

    RecyclerView recyc_event_selected_applicants;
    ArrayList<EventApplicantsPojo> eventApplicants;
    SelectedApplicantsAdapter selectedApplicantsAdapter;

    TextView tv_noapplicants;
    String eventid;

    public SelectedApplicants() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_selectedappicants,container,false);


        recyc_event_selected_applicants = v.findViewById(R.id.recyc_event_selected_applicants);
        eventApplicants = new ArrayList<>();
        selectedApplicantsAdapter = new SelectedApplicantsAdapter(eventApplicants,getActivity(),this);

        recyc_event_selected_applicants.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_event_selected_applicants.setItemAnimator(new DefaultItemAnimator());
        recyc_event_selected_applicants.setAdapter(selectedApplicantsAdapter);

        tv_noapplicants = v.findViewById(R.id.tv_noapplicants);

        eventid = getArguments().getString("eventid");

        setApplicantsData();

        return v;
    }

    private void setApplicantsData() {

        Events events = RetroClient.getClient().create(Events.class);
        Call<EventApplicantsResponse> call = events.getEventApplicants(eventid);
        call.enqueue(new Callback<EventApplicantsResponse>() {
            @Override
            public void onResponse(Call<EventApplicantsResponse> call, Response<EventApplicantsResponse> response) {

                if(response.body().getCode().equals("0")){

                    for(ApplicantData ad : response.body().getApplicantData()){

                        EventApplicantsPojo ev = new EventApplicantsPojo(
                                ad.getUserid(),
                                ad.getApplicationid(),
                                ad.getCurrentemail(),
                                ad.getContactnumber(),
                                ad.getFirstname(),
                                "",
                                ad.getAge(),
                                ad.getGender(),
                                ad.getEducation(),
                                ad.getEducationdetails(),
                                ad.getOrganisationdetails(),
                                ad.getApplicationnote(),
                                ad.getSkillsets(),
                                ad.getPriorteachingexperience(),
                                ad.getIsselected());

                        eventApplicants.add(ev);
                    }

                    selectedApplicantsAdapter.notifyDataSetChanged();
                }else{
                    tv_noapplicants.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<EventApplicantsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void selectedApplicantAllot(String userid,String username) {

        Fragment eve = new PostEventRating();
        Bundle b = new Bundle();
        b.putString("eventid",eventid);
        b.putString("userid",userid);
        b.putString("name",username);
        eve.setArguments(b);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(R.id.container,eve)
                .addToBackStack(null)
                .commit();
    }
}
