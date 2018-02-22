package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.CreateEvent.CreateEventsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetEvents.EventsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 22-02-2018.
 */

public interface Events {

    @GET("events")
    Call<EventsResponse> getEvents(@Query("userid") String userid);

    @GET("createvent")
    Call<CreateEventsResponse> createEvents(@Query("eventtitle") String eventtitle,
                                            @Query("eventhead") String eventhead,
                                            @Query("eventfellow") String eventfellow,
                                            @Query("eventdescription") String eventdescription,
                                            @Query("eventlocation") String eventlocation,
                                            @Query("eventlatlong") String eventlatlong,
                                            @Query("eventmaxpoints") String eventmaxpoints,
                                            @Query("eventimage") String eventimage,
                                            @Query("eventstartdate") String eventstartdate,
                                            @Query("eventenddate") String eventenddate);


}
