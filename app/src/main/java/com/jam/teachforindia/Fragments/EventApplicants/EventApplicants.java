package com.jam.teachforindia.Fragments.EventApplicants;

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

import com.jam.teachforindia.Fragments.Notes.EventConfirmation;
import com.jam.teachforindia.Fragments.Notes.EventRejected;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.ApplicantData;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.EventApplicantsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffUpdateApplication.ApplicationUpdateResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 24-02-2018.
 */

public class EventApplicants extends Fragment implements EventApplicantClicks{

    RecyclerView recyc_eventapplicants;
    ArrayList<EventApplicantsPojo> eventApplicants;
    EventsApplicationAdapter eventsApplicationAdapter;

    public EventApplicants() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_eventapplicant,container,false);

        recyc_eventapplicants = v.findViewById(R.id.recyc_event_applicants);
        eventApplicants = new ArrayList<>();
        eventsApplicationAdapter = new EventsApplicationAdapter(eventApplicants,getActivity(),this);
        
        recyc_eventapplicants.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_eventapplicants.setItemAnimator(new DefaultItemAnimator());
        recyc_eventapplicants.setAdapter(eventsApplicationAdapter);
        
        setApplicantsData();
        
        return v;
    }

    private void setApplicantsData() {
        Events events = RetroClient.getClient().create(Events.class);
        Call<EventApplicantsResponse> call = events.getEventApplicants("0f781df2-12cf-11e8-8f6e-3863bb91cb0c");
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
                                "245",
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

                    eventsApplicationAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<EventApplicantsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSelectedClicked(View v, int isSelected, String applicationid,String name) {
        Toast.makeText(getActivity(), "" + isSelected, Toast.LENGTH_SHORT).show();

        if(isSelected == 2){
            updateToHold(applicationid);
        }else if(isSelected == 1){

            EventConfirmation c = new EventConfirmation();
            Bundle b = new Bundle();
            b.putString("appid",applicationid);
            b.putString("name",name);
            c.setArguments(b);

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,c).addToBackStack(null).commit();
        }else if(isSelected == 3){

            EventRejected r = new EventRejected();
            Bundle b = new Bundle();
            b.putString("appid",applicationid);
            b.putString("name",name);
            r.setArguments(b);

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,r).addToBackStack(null).commit();
        }
    }

    private void updateToHold(String applicationid) {
        Events e = RetroClient.getClient().create(Events.class);
        Call<ApplicationUpdateResponse> call = e.staffupdateapplication(applicationid,"2","");
        call.enqueue(new Callback<ApplicationUpdateResponse>() {
            @Override
            public void onResponse(Call<ApplicationUpdateResponse> call, Response<ApplicationUpdateResponse> response) {

                Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApplicationUpdateResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
