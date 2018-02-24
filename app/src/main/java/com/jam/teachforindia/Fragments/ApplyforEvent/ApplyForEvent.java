package com.jam.teachforindia.Fragments.ApplyforEvent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.ApplyForEvent.EventApplyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Jam on 24-02-2018.
 */

public class ApplyForEvent extends Fragment {

    Button btn_apply;
    EditText et_applicationnote,et_contact,et_email;
    String userid;
    String eventid;
    SessionManager session;

    public ApplyForEvent() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_applyforevent,container,false);

        session = new SessionManager(getActivity());
        userid = session.getUserId();
        eventid = getArguments().getString("eventid");
        Toast.makeText(getActivity(), "heres the event" + eventid, Toast.LENGTH_SHORT).show();
        btn_apply = v.findViewById(R.id.btn_apply);
        et_applicationnote = v.findViewById(R.id.et_applicationnote);
        et_contact = v.findViewById(R.id.et_contact);
        et_email = v.findViewById(R.id.et_email);
        et_email.setText(session.getUserDetails().get(SessionManager.USERNAME));


        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyForEvent();
            }
        });

        return v;
    }

    private void applyForEvent() {
        Events e = RetroClient.getClient().create(Events.class);
        Call<EventApplyResponse> call = e.applyforevent(userid,eventid,et_contact.getText().toString(),et_email.getText().toString(),et_applicationnote.getText().toString());
        call.enqueue(new Callback<EventApplyResponse>() {
            @Override
            public void onResponse(Call<EventApplyResponse> call, Response<EventApplyResponse> response) {

                if(response.body().getCode().equals("0")){
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EventApplyResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
