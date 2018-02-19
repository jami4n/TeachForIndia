package com.jam.teachforindia.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jam.teachforindia.Fragments.Login.LoginFragment;
import com.jam.teachforindia.R;

/**
 * Created by Jam on 07-02-2018.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Fragment f = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.login_container,f).commit();

    }
}
