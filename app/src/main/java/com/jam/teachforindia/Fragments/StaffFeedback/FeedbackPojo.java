package com.jam.teachforindia.Fragments.StaffFeedback;

/**
 * Created by Jam on 26-02-2018.
 */

public class FeedbackPojo {

    String feedbackid;
    String feedback;
    String authorid;


    public FeedbackPojo(String feedbackid, String feedback, String authorid) {
        this.feedbackid = feedbackid;
        this.feedback = feedback;
        this.authorid = authorid;
    }

    public String getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(String feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }
}
