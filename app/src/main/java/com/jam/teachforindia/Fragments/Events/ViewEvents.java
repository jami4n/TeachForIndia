package com.jam.teachforindia.Fragments.Events;

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

import com.jam.teachforindia.Fragments.ApplyforEvent.ApplyForEvent;
import com.jam.teachforindia.Fragments.EventApplicants.EventApplicants;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetEvents.EventsData;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetEvents.EventsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 22-02-2018.
 */

public class ViewEvents extends Fragment implements EventClicks{

    RecyclerView recyc_events;
    EventsAdapter eventsAdapter;
    ArrayList<EventsPojo> events;

    public ViewEvents() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events,container,false);

        recyc_events = v.findViewById(R.id.recyc_events);
        events = new ArrayList<>();
        eventsAdapter = new EventsAdapter(events,getActivity(),this);

        recyc_events.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_events.setItemAnimator(new DefaultItemAnimator());
        recyc_events.setAdapter(eventsAdapter);

        getEvents(0);

        return v;
    }

    private void getEvents(int userid) {

        Events eventsservice = RetroClient.getClient().create(Events.class);
        retrofit2.Call<EventsResponse> call =  eventsservice.getEvents("0");
        call.enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {

                if(response.body().getCode().equals("0")){

                    for(EventsData ed : response.body().getData()){
                        EventsPojo e = new EventsPojo(ed.getEventid(),ed.getEventimage(),ed.getEventtitle(),
                                ed.getEventdescription(),ed.getEventlocation(),ed.getEventlatlong(),
                                ed.getEventstartdate(),ed.getEventenddate());
                        events.add(e);
                    }

                    eventsAdapter.notifyDataSetChanged();


                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
//
//        EventsPojo e = new EventsPojo("1","https://i.pinimg.com/564x/b0/b9/f5/b0b9f5ce3324af26cf989159f9d26437.jpg","Saturday Morning Class",
//                "This happends eery Saturday and this is not possible to happen on Sunday.","Kurla, Mumbai","131.00,451.00",
//                "25/06/1992","25/06/1992");
//        events.add(e);
//
//        EventsPojo e1 = new EventsPojo("2","https://i.pinimg.com/236x/cf/27/90/cf2790e5298f775e5e28b23520ea3235.jpg","Monday Morning Class",
//                "This happends eery Monday and this is not possible to happen on Sunday.","Lower Parel, Mumbai","131.00,451.00",
//                "26/06/1992","26/06/1992");
//        events.add(e1);
//
//        eventsAdapter.notifyDataSetChanged();
    }

    @Override
    public void applyforevent(View v, String eventid) {
        Toast.makeText(getActivity(), "" + eventid, Toast.LENGTH_SHORT).show();

        Fragment f = new ApplyForEvent();
        Bundle b = new Bundle();
        b.putString("eventid",eventid);
        f.setArguments(b);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,f).addToBackStack(null).commit();
    }

    @Override
    public void showApplicants(View v, String eventid) {
        Fragment eve = new EventApplicants();
        Bundle b = new Bundle();
        b.putString("eventid",eventid);
        eve.setArguments(b);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(R.id.container,eve)
                .addToBackStack(null)
                .commit();


    }
}
