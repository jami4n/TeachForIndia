package com.jam.teachforindia.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.jam.teachforindia.Fragments.ApplicationForms.VolunteerApplicationForm;
import com.jam.teachforindia.Fragments.CreateEvent.CreateEvent;
import com.jam.teachforindia.Fragments.EventApplicants.EventApplicants;
import com.jam.teachforindia.Fragments.Events.ViewEvents;
import com.jam.teachforindia.Fragments.Filter.AnalyseFragment;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Fragments.Navigation.NavigationFragment;
import com.jam.teachforindia.Fragments.Notifications.Notifications;
import com.jam.teachforindia.Fragments.Profile.Profile;
import com.jam.teachforindia.Fragments.SendStaffFeedback.FragmentSendStaffFeedback;
import com.jam.teachforindia.Fragments.StaffFeedback.FeedbackFragment;
import com.jam.teachforindia.Fragments.TopVolunteers.TopVolunteersFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.FCMReg;
import com.jam.teachforindia.RetroServices.ServiceResponses.SaveRegistrationResponse.SaveRegResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationFragment.FragmentDrawerListener{

    private static final String TAG = "MainActivity";
    Toolbar toolbar;
    private NavigationFragment drawerFragment;
    SessionManager session;

    public static final String CONNECTION_ERROR = "There seems to be a connection error.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (NavigationFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_view);
        drawerFragment.setUp(R.id.nav_view, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        session = new SessionManager(this);

        String token = FirebaseInstanceId.getInstance().getToken();
        if(token != null){
            FCMReg reg = RetroClient.getClient().create(FCMReg.class);
            Call<SaveRegResponse> call = reg.saveRegistrationId(session.getUserId(),token);
            call.enqueue(new Callback<SaveRegResponse>() {
                @Override
                public void onResponse(Call<SaveRegResponse> call, Response<SaveRegResponse> response) {
                    
                    if(response.body().getCode().equals("0")){
                        //Toast.makeText(MainActivity.this, "FCM activated for user.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SaveRegResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
                }
            });
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        //setFragment(new HomeFragment());
    }

    private void setFragment(Fragment fragment) {
        if (fragment.getClass().equals(new HomeFragment().getClass())){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();
        }
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDrawerItemSelected(View view, int position, String link) {

        if(link.toLowerCase().equals("home")){
            setFragment(new HomeFragment());
        }else if(link.toLowerCase().equals("events")){
            setFragment(new ViewEvents());
            setTitle("Events");
        }else if(link.toLowerCase().equals("create events")){
            setFragment(new CreateEvent());
            setTitle("Create Event");
        }else if(link.toLowerCase().equals("update profile")){
            setFragment(new VolunteerApplicationForm());
            setTitle("Profile Update");
        }else if(link.toLowerCase().equals("notifications")){
            setFragment(new Notifications());
            setTitle("Notifications");
        }else if(link.toLowerCase().equals("profile")){
            setTitle("");
            setFragment(new Profile());
        }else if(link.toLowerCase().equals("top volunteers")){
            setTitle("Top Volunteers");
            setFragment(new TopVolunteersFragment());
        }else if(link.toLowerCase().equals("feedback")){
            setTitle("Staff feedback");
            setFragment(new FeedbackFragment());
        }else if(link.toLowerCase().equals("staff feedback")){
            setTitle("Send Feedback");
            setFragment(new FragmentSendStaffFeedback());
        }else if(link.toLowerCase().equals("logout")){
            session.setUserLoggedOut();
            Intent i = new Intent(MainActivity.this,LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
}
