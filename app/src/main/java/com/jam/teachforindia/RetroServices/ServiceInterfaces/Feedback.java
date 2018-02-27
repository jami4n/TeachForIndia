package com.jam.teachforindia.RetroServices.ServiceInterfaces;

import com.jam.teachforindia.RetroServices.ServiceResponses.ApplyForEvent.EventApplyResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.Feedback.FeedbackResponse;
import com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback.SendStaffFeedbackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jam on 26-02-2018.
 */

public interface Feedback {

    @GET("oneventcompletion")
    Call<FeedbackResponse> sendFeedback(@Query("userid") String userid,@Query("eventid") String eventid,@Query("score") String score,@Query("note") String feedback,@Query("imagepath") String imagepath);

    @GET("getstafffeedback")
    Call<com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback.FeedbackResponse> getStaffFeedback();

    @GET("sendstafffeedback")
    Call<SendStaffFeedbackResponse> sendStaffFeedback(@Query("userid") String userId,@Query("feedback") String feedback);

}
