package com.jam.teachforindia.Fragments.Notes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Events;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffUpdateApplication.ApplicationUpdateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 11-02-2018.
 */

public class EventConfirmation extends Fragment {


    Button btn_reject;
    EditText et_staffnote;
    TextView tv_name;

    String applicationId;

    SessionManager session;


    public EventConfirmation() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_eventconfirmation,container,false);


        session = new SessionManager(getActivity());

        applicationId = getArguments().getString("appid");
        String name = getArguments().getString("name").split(" ")[0];

        et_staffnote = v.findViewById(R.id.tv_staffnote);
        tv_name = v.findViewById(R.id.tv_name);
        tv_name.setText("Hi " + name);

        btn_reject = v.findViewById(R.id.btn_reject);
        btn_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmApplicant();
            }
        });

        return v;
    }

    private void confirmApplicant() {

        Events e = RetroClient.getClient().create(Events.class);
        Call<ApplicationUpdateResponse> call = e.staffupdateapplication(applicationId,"1",et_staffnote.getText().toString());
        call.enqueue(new Callback<ApplicationUpdateResponse>() {
            @Override
            public void onResponse(Call<ApplicationUpdateResponse> call, Response<ApplicationUpdateResponse> response) {

                Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                if(response.body().getCode().equals("0")){
                    getFragmentManager().popBackStackImmediate();
                }
            }

            @Override
            public void onFailure(Call<ApplicationUpdateResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
