package com.jam.teachforindia.Fragments.CreateEvent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Events.EventsAdapter;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.CreateEvent.CreateEventsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 22-02-2018.
 */

public class CreateEvent extends Fragment {

    Button btn_create_event;
    EditText et_eventtitle,et_eventdescript,et_location,et_maxpoints,et_image,et_startdate,et_enddate;
    SessionManager session;

    public CreateEvent() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_event,container,false);

        session = new SessionManager(getActivity());

        btn_create_event = v.findViewById(R.id.btn_create_event);
        btn_create_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEvent();
            }
        });


        et_eventtitle = v.findViewById(R.id.et_eventtitle);
        et_eventdescript = v.findViewById(R.id.et_eventdescript);
        et_location = v.findViewById(R.id.et_location);
        et_maxpoints = v.findViewById(R.id.et_maxpoints);
        et_image = v.findViewById(R.id.et_image);
        et_startdate = v.findViewById(R.id.et_startdate);
        et_enddate = v.findViewById(R.id.et_enddate);

        return v;
    }

    private void createEvent() {
        String eventtitle = et_eventtitle.getText().toString();
        String eventhead  = session.getUserId();
        String eventfellow  = session.getUserId();
        String eventdescription  = et_eventdescript.getText().toString();
        String eventlocation  = et_location.getText().toString();
        String eventlatlong  = "0";
        String eventmaxpoints = et_maxpoints.getText().toString();
        String eventimage  = et_image.getText().toString();
        String eventstartdate  = et_startdate.getText().toString();
        String eventenddate  = et_enddate.getText().toString();

        Events eventsService = RetroClient.getClient().create(Events.class);
        Call<CreateEventsResponse> call = eventsService.createEvents(eventtitle,eventhead,eventfellow,eventdescription,eventlocation,eventlatlong, eventmaxpoints,eventimage,eventstartdate, eventenddate);
        call.enqueue(new Callback<CreateEventsResponse>() {
            @Override
            public void onResponse(Call<CreateEventsResponse> call, Response<CreateEventsResponse> response) {

                if(response.body().getCode().equals("0")){
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateEventsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
