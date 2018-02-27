package com.jam.teachforindia.Fragments.SendStaffFeedback;

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

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Feedback;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback.SendStaffFeedbackResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 27-02-2018.
 */

public class FragmentSendStaffFeedback extends Fragment {

    EditText et_feedback;
    Button btn_sendfeedback;

    SessionManager session;

    public FragmentSendStaffFeedback() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sendstafffeedback,container,false);

        session = new SessionManager(getActivity());

        et_feedback = v.findViewById(R.id.et_feedback);
        btn_sendfeedback = v.findViewById(R.id.btn_sendfeedback);
        btn_sendfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });
        return v;
    }

    private void sendFeedback() {

        Feedback f = RetroClient.getClient().create(Feedback.class);
        Call<SendStaffFeedbackResponse> call = f.sendStaffFeedback(session.getUserId(),et_feedback.getText().toString());
        call.enqueue(new Callback<SendStaffFeedbackResponse>() {
            @Override
            public void onResponse(Call<SendStaffFeedbackResponse> call, Response<SendStaffFeedbackResponse> response) {

                Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).addToBackStack(null).commit();
            }

            @Override
            public void onFailure(Call<SendStaffFeedbackResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
