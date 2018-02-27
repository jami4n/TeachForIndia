package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.getNotifications.NotificationsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 25-02-2018.
 */

public interface Notifications {

    @GET("getnotifications")
    Call<NotificationsResponse> getNotifications(@Query("userid") String userid);

}
