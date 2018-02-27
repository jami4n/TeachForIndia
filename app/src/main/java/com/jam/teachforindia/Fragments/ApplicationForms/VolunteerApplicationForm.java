package com.jam.teachforindia.Fragments.ApplicationForms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.UserUpdate;
import com.jam.teachforindia.RetroServices.ServiceRequests.UpdateUserRequest.UpdateUserRequest;
import com.jam.teachforindia.RetroServices.ServiceResponses.UpdateUser.UpdateUserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 07-02-2018.
 */

public class VolunteerApplicationForm extends Fragment{

    EditText et_name,et_age,et_contact,et_email,et_address,et_educationdetails,et_work_details,et_volunteer_reason,et_othersupport;
    ImageView iv_boy,iv_girl;
    Spinner sp_education,sp_city;
    TextView tv_availablemonth_jja,tv_availablemonth_ond,tv_availablemonth_jfm,tv_availablemonth_all;
    TextView et_monday,et_tuesday,et_wednesday,et_thursday,et_friday,et_saturday;
    TextView tv_07301230,tv_12300530;
    TextView tv_classroom,tv_adolescence,tv_extras,tv_research,tv_funds,tv_social_media;
    TextView tv_teachingexp_no,tv_teachingexp_yes;
    TextView tv_priorapplied_yes,tv_priorapplied_no;
    TextView tv_postgrad,tv_grad,tv_undergrad,tv_school;

    String gendertab;
    String education;
    ArrayList<String> availablemonths;
    ArrayList<String> availabledays;
    ArrayList<String> time;
    ArrayList<String> skillset;
    boolean hasteachingexperience;
    boolean haspriorapplied;

    SessionManager session;

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

        //initialising xml data

        et_name = v.findViewById(R.id.et_name);
        et_age = v.findViewById(R.id.et_age);
        et_contact = v.findViewById(R.id.et_contact);
        et_email = v.findViewById(R.id.et_email);
        et_address = v.findViewById(R.id.et_address);
        et_educationdetails = v.findViewById(R.id.et_educationdetails);
        et_work_details = v.findViewById(R.id.et_work_details);
        et_volunteer_reason = v.findViewById(R.id.et_volunteer_reason);
        et_othersupport = v.findViewById(R.id.et_othersupport);

        tv_availablemonth_jja = v.findViewById(R.id.tv_availablemonth_jja);
        tv_availablemonth_ond = v.findViewById(R.id.tv_availablemonth_ond);
        tv_availablemonth_ond = v.findViewById(R.id.tv_availablemonth_ond);
        tv_availablemonth_jfm = v.findViewById(R.id.tv_availablemonth_jfm);
        tv_availablemonth_all = v.findViewById(R.id.tv_availablemonth_all);


        et_monday = v.findViewById(R.id.et_monday);
        et_tuesday = v.findViewById(R.id.et_tuesday);
        et_wednesday = v.findViewById(R.id.et_wednesday);
        et_thursday = v.findViewById(R.id.et_thursday);
        et_friday = v.findViewById(R.id.et_friday);
        et_saturday = v.findViewById(R.id.et_saturday);

        tv_07301230 = v.findViewById(R.id.tv_07301230);
        tv_12300530 = v.findViewById(R.id.tv_12300530);

        tv_classroom = v.findViewById(R.id.tv_classroom);
        tv_adolescence = v.findViewById(R.id.tv_adolescence);
        tv_extras = v.findViewById(R.id.tv_extras);
        tv_research = v.findViewById(R.id.tv_research);
        tv_funds = v.findViewById(R.id.tv_funds);
        tv_social_media = v.findViewById(R.id.tv_social_media);

        tv_teachingexp_no = v.findViewById(R.id.tv_teachingexp_no);
        tv_teachingexp_yes = v.findViewById(R.id.tv_teachingexp_yes);

        tv_priorapplied_yes = v.findViewById(R.id.tv_priorapplied_yes);
        tv_priorapplied_no = v.findViewById(R.id.tv_priorapplied_no);

        iv_boy = v.findViewById(R.id.iv_boy);
        iv_girl = v.findViewById(R.id.iv_girl);
//        sp_education = v.findViewById(R.id.sp_education);
//        sp_city = v.findViewById(R.id.sp_city);

        tv_postgrad = v.findViewById(R.id.tv_postgrad);
        tv_grad = v.findViewById(R.id.tv_grad);
        tv_undergrad = v.findViewById(R.id.tv_undergrad);
        tv_school = v.findViewById(R.id.tv_school);

        //end of initialising xml data


        //initialising page data

        education = "Graduate";
        gendertab = "Male";
        availablemonths = new ArrayList<>();
        availabledays = new ArrayList<>();
        time = new ArrayList<>();
        skillset = new ArrayList<>();
        hasteachingexperience = false;
        haspriorapplied = false;

        //end of initialising page data

        //setting clicks

        tv_grad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_grad.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    tv_grad.setTextColor(getResources().getColor(R.color.color_black));
                    education = "";
                }else{
                    tv_grad.setTextColor(getResources().getColor(R.color.color_blue));
                    education = "Graduate";

                    tv_postgrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_undergrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_school.setTextColor(getResources().getColor(R.color.color_black));
                }

                Log.d("123456", "onClick: " + education);
            }
        });

        tv_postgrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_postgrad.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    tv_postgrad.setTextColor(getResources().getColor(R.color.color_black));
                    education = "";
                }else{
                    tv_postgrad.setTextColor(getResources().getColor(R.color.color_blue));
                    education = "Post Graduate";

                    tv_grad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_undergrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_school.setTextColor(getResources().getColor(R.color.color_black));
                }

                Log.d("123456", "onClick: " + education);
            }
        });

        tv_undergrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_undergrad.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    tv_undergrad.setTextColor(getResources().getColor(R.color.color_black));
                    education = "";
                }else{
                    tv_undergrad.setTextColor(getResources().getColor(R.color.color_blue));
                    education = "Pursuing UnderGraduate Degree";

                    tv_postgrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_grad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_school.setTextColor(getResources().getColor(R.color.color_black));
                }

                Log.d("123456", "onClick: " + education);
            }
        });

        tv_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_school.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    tv_school.setTextColor(getResources().getColor(R.color.color_black));
                    education = "";
                }else{
                    tv_school.setTextColor(getResources().getColor(R.color.color_blue));
                    education = "In School";

                    tv_postgrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_undergrad.setTextColor(getResources().getColor(R.color.color_black));
                    tv_grad.setTextColor(getResources().getColor(R.color.color_black));
                }

                Log.d("123456", "onClick: " + education);
            }
        });

        iv_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(getActivity()).load(R.drawable.boy).into(iv_boy);
                Glide.with(getActivity()).load(R.drawable.girl_line).into(iv_girl);
                gendertab = "Male";

            }
        });
        iv_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(getActivity()).load(R.drawable.boy_line).into(iv_boy);
                Glide.with(getActivity()).load(R.drawable.girl).into(iv_girl);
                gendertab = "Female";

            }
        });

        tv_availablemonth_jja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_availablemonth_jja.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availablemonths.remove("June-July-August");
                    tv_availablemonth_jja.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_availablemonth_jja.setTextColor(getResources().getColor(R.color.color_blue));
                    availablemonths.add("June-July-August");
                }
                printarray(availablemonths);
            }
        });

        tv_availablemonth_ond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_availablemonth_ond.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availablemonths.remove("October-November-December");
                    tv_availablemonth_ond.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_availablemonth_ond.setTextColor(getResources().getColor(R.color.color_blue));
                    availablemonths.add("October-November-December");
                }
                printarray(availablemonths);
            }
        });
        tv_availablemonth_jfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_availablemonth_jfm.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availablemonths.remove("January-February-March");
                    tv_availablemonth_jfm.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_availablemonth_jfm.setTextColor(getResources().getColor(R.color.color_blue));
                    availablemonths.add("January-February-March");
                }
                printarray(availablemonths);
            }
        });

        tv_availablemonth_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_availablemonth_all.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availablemonths.remove("I am available during all months");
                    tv_availablemonth_all.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_availablemonth_all.setTextColor(getResources().getColor(R.color.color_blue));
                    tv_availablemonth_jfm.setTextColor(getResources().getColor(R.color.color_black));
                    tv_availablemonth_ond.setTextColor(getResources().getColor(R.color.color_black));
                    tv_availablemonth_jja.setTextColor(getResources().getColor(R.color.color_black));
                    availablemonths.clear();
                    availablemonths.add("I am available during all months");
                }

                printarray(availablemonths);

            }
        });

        et_monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_monday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Monday");
                    et_monday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_monday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Monday");
                }
                printarray(availabledays);
            }
        });
        et_tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_tuesday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Tuesday");
                    et_tuesday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_tuesday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Tuesday");
                }
                printarray(availabledays);
            }
        });
        et_wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_wednesday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Wednesday");
                    et_wednesday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_wednesday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Wednesday");
                }
                printarray(availabledays);
            }
        });
        et_thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_thursday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Thursday");
                    et_thursday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_thursday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Thursday");
                }
                printarray(availabledays);
            }
        });
        et_friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_friday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Friday");
                    et_friday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_friday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Friday");
                }
                printarray(availabledays);
            }
        });
        et_saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_saturday.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    availabledays.remove("Saturday");
                    et_saturday.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    et_saturday.setTextColor(getResources().getColor(R.color.color_blue));
                    availabledays.add("Saturday");
                }
                printarray(availabledays);
            }
        });


        tv_07301230.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_07301230.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    time.remove("07.30 - 12.30");
                    tv_07301230.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_07301230.setTextColor(getResources().getColor(R.color.color_blue));
                    time.add("07.30 - 12.30");
                }
                printarray(time);
            }
        });
        tv_12300530.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_12300530.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    time.remove("12.30 - 05.30");
                    tv_12300530.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_12300530.setTextColor(getResources().getColor(R.color.color_blue));
                    time.add("12.30 - 05.30");
                }
                printarray(time);
            }
        });

        tv_classroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_classroom.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Classroom instruction");
                    tv_classroom.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_classroom.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Classroom instruction");
                }
                printarray(skillset);
            }
        });
        tv_adolescence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_adolescence.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Adolescent support");
                    tv_adolescence.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_adolescence.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Adolescent support");
                }
                printarray(skillset);
            }
        });
        tv_extras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_extras.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Extra-curricular workshops/discussions");
                    tv_extras.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_extras.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Extra-curricular workshops/discussions");
                }
                printarray(skillset);
            }
        });
        tv_research.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_research.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Research and data analysis");
                    tv_research.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_research.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Research and data analysis");
                }
                printarray(skillset);
            }
        });
        tv_funds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_funds.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Fund-raising");
                    tv_funds.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_funds.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Fund-raising");
                }
                printarray(skillset);
            }
        });
        tv_social_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_social_media.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    skillset.remove("Social media");
                    tv_social_media.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_social_media.setTextColor(getResources().getColor(R.color.color_blue));
                    skillset.add("Social media");
                }
                printarray(skillset);
            }
        });

        tv_teachingexp_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tv_teachingexp_no.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    hasteachingexperience = false;
                    tv_teachingexp_no.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_teachingexp_no.setTextColor(getResources().getColor(R.color.color_blue));
                    tv_teachingexp_yes.setTextColor(getResources().getColor(R.color.color_black));
                    hasteachingexperience = false;
                }
                Log.d("123456", "onClick: " + hasteachingexperience);

            }
        });
        tv_teachingexp_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tv_teachingexp_yes.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    hasteachingexperience = false;
                    tv_teachingexp_yes.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_teachingexp_yes.setTextColor(getResources().getColor(R.color.color_blue));
                    tv_teachingexp_no.setTextColor(getResources().getColor(R.color.color_black));
                    hasteachingexperience = true;
                }
                Log.d("123456", "onClick: " + hasteachingexperience);
            }
        });

        tv_priorapplied_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_priorapplied_yes.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    haspriorapplied = false;
                    tv_priorapplied_yes.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_priorapplied_yes.setTextColor(getResources().getColor(R.color.color_blue));
                    tv_priorapplied_no.setTextColor(getResources().getColor(R.color.color_black));
                    haspriorapplied = true;
                }
                Log.d("123456", "onClick: " + haspriorapplied);
            }
        });
        tv_priorapplied_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tv_priorapplied_no.getCurrentTextColor() == getResources().getColor(R.color.color_blue)){
                    haspriorapplied = false;
                    tv_priorapplied_no.setTextColor(getResources().getColor(R.color.color_black));
                }else{
                    tv_priorapplied_no.setTextColor(getResources().getColor(R.color.color_blue));
                    tv_priorapplied_yes.setTextColor(getResources().getColor(R.color.color_black));
                    haspriorapplied = false;
                }
                Log.d("123456", "onClick: " + haspriorapplied);
            }
        });


        //end of setting clicks


        session = new SessionManager(getActivity());
        et_name.setText(session.getUserDetails().get(SessionManager.NAME));
        et_email.setText(session.getUserDetails().get(SessionManager.USERNAME));

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
        String userid = session.getUserId();
        String firstname = et_name.getText().toString();
        String lastname = "";
        String age = et_age.getText().toString();
        String gender = gendertab;
        String contactnumber = et_contact.getText().toString();
        String currentemail = et_email.getText().toString();
        String address = et_address.getText().toString();
        String educationn = education;
        String educationdetails = et_educationdetails.getText().toString();
        String organisationdetails = et_work_details.getText().toString();
        String availablemonthss = printarray(availablemonths); //availabledays.toArray().toString();
        String availableweekdays = printarray(availabledays); //availabledays.toArray().toString();
        String availabletimeslot = printarray(time); //time.toArray().toString();
        String skillsets = printarray(skillset); //skillset.toArray().toString();
        String preferedcity = "Mumbai";
        String volunteerreason = et_volunteer_reason.getText().toString();
        String priorteachingexperience = hasteachingexperience == true ? "Yes" : "No";
        String priorapplication = haspriorapplied == true ? "Yes" : "No";
        String othersupport = et_othersupport.getText().toString();

        session.setGender(gendertab);

        UpdateUserRequest userdata = new UpdateUserRequest(userid,firstname,lastname,age,
                gender,contactnumber,currentemail,
                address,educationn,educationdetails,
                organisationdetails,availablemonthss,availableweekdays,
                availabletimeslot,skillsets,preferedcity,volunteerreason,
                priorteachingexperience,priorapplication,othersupport);

        UserUpdate userupdate = RetroClient.getClient().create(UserUpdate.class);
        Call<UpdateUserResponse> call = userupdate.updateUser(userdata);
        call.enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {

                if(session.getUserRole().equals("N")){
                    session.setUserRole("V");
                }

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).addToBackStack(null).commit();
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String printarray(ArrayList<String> array){
        String data = "";
        int i = 0;
        for(String x : array){
            if(i>0) data += ",";
            data += x;
            i++;
        }

        Log.d("123456", data);
        Log.d("123456", "printarray: -------------------------------------------------------------------------");
        return data;
    }
}
