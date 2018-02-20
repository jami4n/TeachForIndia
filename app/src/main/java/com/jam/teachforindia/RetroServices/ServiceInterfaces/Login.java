package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.Login.LoginResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 20-02-2018.
 */

public interface Login {

    @GET("login")
    Call<LoginResponse> loginuser(@Query("q") String username, @Query("password") String password);

    @GET("register")
    Call<RegisterResponse> registeruser(@Query("email") String username, @Query("password") String password, @Query("name") String name);

}
