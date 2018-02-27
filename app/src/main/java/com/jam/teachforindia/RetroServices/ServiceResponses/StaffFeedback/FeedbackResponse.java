package com.jam.teachforindia.RetroServices.ServiceResponses.StaffFeedback;

import java.util.ArrayList;

/**
 * Created by Jam on 26-02-2018.
 */

public class FeedbackResponse {

    String code;
    String message;
    ArrayList<StaffFeedbackData> data;

    public FeedbackResponse(String code, String message, ArrayList<StaffFeedbackData> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<StaffFeedbackData> getData() {
        return data;
    }

    public void setData(ArrayList<StaffFeedbackData> data) {
        this.data = data;
    }
}
