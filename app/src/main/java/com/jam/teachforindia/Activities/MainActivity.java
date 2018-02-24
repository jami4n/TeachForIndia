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

import com.jam.teachforindia.Fragments.ApplicationForms.VolunteerApplicationForm;
import com.jam.teachforindia.Fragments.CreateEvent.CreateEvent;
import com.jam.teachforindia.Fragments.EventApplicants.EventApplicants;
import com.jam.teachforindia.Fragments.Events.ViewEvents;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Fragments.Navigation.NavigationFragment;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;

public class MainActivity extends AppCompatActivity implements NavigationFragment.FragmentDrawerListener{

    private static final String TAG = "MainActivity";
    Toolbar toolbar;
    private NavigationFragment drawerFragment;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (NavigationFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_view);
        drawerFragment.setUp(R.id.nav_view, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        session = new SessionManager(this);

        setFragment(new HomeFragment());
    }

    private void setFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDrawerItemSelected(View view, int position, String link) {

        if(link.toLowerCase().equals("home")){
            setFragment(new HomeFragment());
        }else if(link.toLowerCase().equals("events")){
            setFragment(new ViewEvents());
        }else if(link.toLowerCase().equals("create events")){
            setFragment(new CreateEvent());
        }else if(link.toLowerCase().equals("update profile")){
            setFragment(new VolunteerApplicationForm());
        }else if(link.toLowerCase().equals("logout")){
            session.setUserLoggedOut();
            Intent i = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
        }
    }
}
