package com.jam.teachforindia.RetroServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jam on 20-02-2018.
 */

public class RetroClient {

    public static final String BASE_URL = "http://tfiweb.herokuapp.com/";
    //public static final String BASE_URL = "http://192.168.1.4:3000/";
    private static Retrofit retroClient = null;

    public static Retrofit getClient(){

        if(retroClient == null){
            retroClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retroClient;
    }
}
