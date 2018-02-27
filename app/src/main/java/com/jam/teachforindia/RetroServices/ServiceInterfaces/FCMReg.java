package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.SaveRegistrationResponse.SaveRegResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 27-02-2018.
 */

public interface FCMReg {

    @GET("saveregistrationid")
    Call<SaveRegResponse> saveRegistrationId(@Query("userid") String userid, @Query("regid") String regid);
}
