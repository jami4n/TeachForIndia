package com.jam.teachforindia.RetroServices.ServiceResponses.Feedback;

/**
 * Created by Jam on 26-02-2018.
 */

public class FeedbackResponse {

    String code;
    String message;

    public FeedbackResponse(String code, String message) {
        this.code = code;
        this.message = message;
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
}
