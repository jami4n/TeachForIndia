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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Filter.AnalyseFragment;
import com.jam.teachforindia.Fragments.Filter.FilterByFragment;
import com.jam.teachforindia.Fragments.Notes.EventConfirmation;
import com.jam.teachforindia.Fragments.Notes.EventRejected;
import com.jam.teachforindia.Fragments.Notes.PostEventRating;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.ApplicantData;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.EventApplicantsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffUpdateApplication.ApplicationUpdateResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    TextView tv_noapplicants;
    Button btn_filter,btn_analyse;

    String sortby;

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

        tv_noapplicants = v.findViewById(R.id.tv_noapplicants);

        setApplicantsData(getArguments().getString("eventid"));

        sortby = getArguments().getString("sortby");

        btn_filter = v.findViewById(R.id.btn_filter);
        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment eve = new FilterByFragment();
                Bundle b = new Bundle();
                b.putString("eventid",getArguments().getString("eventid"));
                eve.setArguments(b);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                        .replace(R.id.container,eve)
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn_analyse = v.findViewById(R.id.btn_analyse);
        btn_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment eve = new AnalyseFragment();
                Bundle b = new Bundle();
                b.putString("eventid",getArguments().getString("eventid"));
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

    private void setApplicantsData(String eventid) {
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

                    eventsApplicationAdapter.notifyDataSetChanged();
                    
                    SortVolunteers();
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

    private void SortVolunteers() {

        if(sortby != null){


            if(sortby.equals("age")){

                Collections.sort(eventApplicants, new Comparator<EventApplicantsPojo>() {
                    @Override
                    public int compare(EventApplicantsPojo o1, EventApplicantsPojo o2) {
                        return o1.getAge().compareTo(o2.getAge());
                    }
                });
            }


            if(sortby.equals("gen")){

                Collections.sort(eventApplicants, new Comparator<EventApplicantsPojo>() {
                    @Override
                    public int compare(EventApplicantsPojo o1, EventApplicantsPojo o2) {
                        return o1.getGender().compareTo(o2.getGender());
                    }
                });

            }


            if(sortby.equals("edu")){

                Collections.sort(eventApplicants, new Comparator<EventApplicantsPojo>() {
                    @Override
                    public int compare(EventApplicantsPojo o1, EventApplicantsPojo o2) {

                        //Post Graduate
                        //Graduate
                        //Pursuing UnderGraduate Degree
                        //In School

                        if(o1.equals(o2)){
                            return 0;
                        }

                        if(o1.getEducation().equals("Post Graduate") && (o2.getEducation().equals("Pursuing UnderGraduate Degree") || o2.getEducation().equals("Graduate") || o2.getEducation().equals("In School"))){
                            return 1;
                        }else if(o1.getEducation().equals("Graduate") && (o2.getEducation().equals("Pursuing UnderGraduate Degree") || o2.getEducation().equals("In School"))){
                            return 1;
                        }else if(o1.getEducation().equals("Pursuing UnderGraduate Degree") && o2.getEducation().equals("In School")){
                            return 1;
                        }else{
                            return -1;
                        }
                        //return o1.getEducation().compareTo(o2.getEducation());
                    }
                });

                Collections.reverse(eventApplicants);
            }

        }

    }

    @Override
    public void onSelectedClicked(View v, int isSelected, String applicationid,String name) {

        if(isSelected == 2){
            TextView t = (TextView) v;
            t.setText("On Hold");
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
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
