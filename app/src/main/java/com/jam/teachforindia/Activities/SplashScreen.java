package com.jam.teachforindia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jam on 24-02-2018.
 */

public class SplashScreen extends AppCompatActivity {

    SessionManager session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new SessionManager(this);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                checkLogin();
            }
        },3000);

    }

    private void checkLogin() {
        Intent i;

        Log.d("123456", "checkLogin: " + session.isLoggedIn());

        if(session.isLoggedIn()){
            i = new Intent(this,MainActivity.class);
        }else{
            i = new Intent(this,LoginActivity.class);
        }
        startActivity(i);
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left);
    }
}
