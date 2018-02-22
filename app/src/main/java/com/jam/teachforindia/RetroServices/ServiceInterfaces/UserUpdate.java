package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceRequests.UpdateUserRequest.UpdateUserRequest;
import com.jam.teachforindia.RetroServices.ServiceResponses.UpdateUser.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Jam on 22-02-2018.
 */

public interface UserUpdate {

    @Headers("Content-Type: application/json")
    @POST("updateuserdata")
    Call<UpdateUserResponse> updateUser(@Body UpdateUserRequest userdata);

}
