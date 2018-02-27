package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.SetTitles.SetTitlesResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.Titles.TitlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 26-02-2018.
 */

public interface Titles {

    @GET("gettitles")
    Call<TitlesResponse> getTitles(@Query("score") String score);

    @GET("settitles")
    Call<SetTitlesResponse> setTitles(@Query("userid") String userid,@Query("title") String title);

}
