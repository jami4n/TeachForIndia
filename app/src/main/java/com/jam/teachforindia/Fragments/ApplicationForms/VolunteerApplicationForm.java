package com.jam.teachforindia.Fragments.ApplicationForms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.UserUpdate;
import com.jam.teachforindia.RetroServices.ServiceRequests.UpdateUserRequest.UpdateUserRequest;
import com.jam.teachforindia.RetroServices.ServiceResponses.UpdateUser.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 07-02-2018.
 */

public class VolunteerApplicationForm extends Fragment{


    public VolunteerApplicationForm() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_volunt_applic_form,container,false);

        Button btn_save_userdata = v.findViewById(R.id.btn_save_userdata);
        btn_save_userdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        return v;
    }

    //edd7f463-12c1-11e8-8f6e-3863bb91cb0c

    public void updateUser(){
        String userid = "edd7f463-12c1-11e8-8f6e-3863bb91cb0c";
        String firstname = "Darren Gonsalves";
        String lastname = "";
        String age = "18";
        String gender = "Male";
        String contactnumber = "9987272755";
        String currentemail = "darren@test.com";
        String address = "Kalina,Mumbai";
        String education = "Under Graduation";
        String educationdetails = "Studying Accounting and Finance";
        String organisationdetails = "";
        String availablemonths = "June to August";
        String availableweekdays = "Monday,Tuesday,Wednesday";
        String availabletimeslot = "7.00-9.00";
        String skillsets = "Education,Football";
        String preferedcity = "Ooty";
        String volunteerreason = "";
        String priorteachingexperience = "None";
        String priorapplication = "No";
        String othersupport = "No";

        UpdateUserRequest userdata = new UpdateUserRequest(userid,firstname,lastname,age,
                gender,contactnumber,currentemail,
                address,education,educationdetails,
                organisationdetails,availablemonths,availableweekdays,
                availabletimeslot,skillsets,preferedcity,volunteerreason,
                priorteachingexperience,priorapplication,othersupport);

        UserUpdate userupdate = RetroClient.getClient().create(UserUpdate.class);
        Call<UpdateUserResponse> call = userupdate.updateUser(userdata);
        call.enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
