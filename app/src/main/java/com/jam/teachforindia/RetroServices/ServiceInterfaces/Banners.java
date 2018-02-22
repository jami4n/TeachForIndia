package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.GetBanner.BannerData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jam on 22-02-2018.
 */

public interface Banners {

    @GET("banners")
    Call<ArrayList<BannerData>> getBanners();

}
