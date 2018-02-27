package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.GetScore.ScoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 26-02-2018.
 */

public interface Profile {

    @GET("getscore")
    Call<ScoreResponse> getScore(@Query("userid") String userid);

}
