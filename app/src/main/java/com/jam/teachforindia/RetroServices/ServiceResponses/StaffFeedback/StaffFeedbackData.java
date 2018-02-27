package com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback;

/**
 * Created by Jam on 26-02-2018.
 */

public class StaffFeedbackData {

    String feedback;
    String authorid;
    String stafffeedbackid;
    String forevent;

    public StaffFeedbackData(String feedback, String authorid, String stafffeedbackid, String forevent) {
        this.feedback = feedback;
        this.authorid = authorid;
        this.stafffeedbackid = stafffeedbackid;
        this.forevent = forevent;
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

    public String getStafffeedbackid() {
        return stafffeedbackid;
    }

    public void setStafffeedbackid(String stafffeedbackid) {
        this.stafffeedbackid = stafffeedbackid;
    }

    public String getForevent() {
        return forevent;
    }

    public void setForevent(String forevent) {
        this.forevent = forevent;
    }
}
