package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.ApplyForEvent.EventApplyResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.CreateEvent.CreateEventsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants.EventApplicantsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetEvents.EventsResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffUpdateApplication.ApplicationUpdateResponse;

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

    @GET("getapplications")
    Call<EventApplicantsResponse> getEventApplicants(@Query("eventid") String eventid);


    @GET("applyforevent")
    Call<EventApplyResponse> applyforevent(@Query("userid") String userid,@Query("eventid") String eventid,
                                           @Query("contact") String contact,@Query("email") String email,
                                           @Query("note") String note);

    @GET("staffupdateeventapplication")
    Call<ApplicationUpdateResponse> staffupdateapplication(@Query("eventapplicationid") String eventapplicationid, @Query("isselected") String isselected, @Query("staffnote") String staffnote);

}
