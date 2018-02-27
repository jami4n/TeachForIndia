package com.jam.teachforindia.Generic;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.jam.teachforindia.RetroServices.RetroClient;

/**
 * Created by Jam on 27-02-2018.
 */

public class FirebaseService extends FirebaseInstanceIdService {

    private static final String TAG = "123456";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);


    }
}
