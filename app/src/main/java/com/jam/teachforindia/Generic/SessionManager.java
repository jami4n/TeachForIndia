package com.jam.teachforindia.Generic;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Jam on 22-02-2018.
 */

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    private static final String PREF_NAME = "TeachforIndia";

    // All Shared Preferences Keys
    private static final String IS_LOGGED_IN = "IsLoggedIn";
    private static final String USER_ID = "UserID";
    private static final String USERNAME = "UserEmail";
    private static final String ROLE = "UserRole";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(PREF_NAME,0);
        editor = sharedPreferences.edit();
    }


    public void setUserLoggedIn(String username, String userid, String role){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USERNAME, username);
        editor.putString(USER_ID, userid);
        editor.putString(ROLE, role);
        editor.commit();
    }


    public void setUserLoggedOut(){
        editor.putBoolean(IS_LOGGED_IN, false);
        editor.putString(USERNAME, null);
        editor.putString(USER_ID, null);
        editor.putString(ROLE, null);
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(USER_ID, sharedPreferences.getString(USER_ID, null));
        user.put(ROLE, sharedPreferences.getString(ROLE, null));
        return user;
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }

    public String getUserRole(){
        return sharedPreferences.getString(ROLE,null);
    }
    public String getUserId(){
        return sharedPreferences.getString(USER_ID,null);
    }



}
