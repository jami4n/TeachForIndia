package com.jam.teachforindia.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jam.teachforindia.Fragments.ApplicationForms.VolunteerApplicationForm;
import com.jam.teachforindia.Fragments.Home.HomeFragment;
import com.jam.teachforindia.Fragments.Notes.EventConfirmation;
import com.jam.teachforindia.Fragments.Notes.EventRejected;
import com.jam.teachforindia.Fragments.Notes.PostEventRating;
import com.jam.teachforindia.R;

public class MainActivity extends AppCompatActivity {

    TextView tv_volform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tv_volform = findViewById(R.id.tv_volform);


        setFragment(new VolunteerApplicationForm());
    }

    private void setFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

    }
}
