package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.TopVolunteers.TopVolResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jam on 26-02-2018.
 */

public interface TopVolunteers {

    @GET("gettopvolunteers")
    Call<TopVolResponse> getTopVolunteers();
}
