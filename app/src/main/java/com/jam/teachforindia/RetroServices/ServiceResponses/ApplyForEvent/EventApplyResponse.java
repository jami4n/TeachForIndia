package com.jam.teachforindia.RetroServices.ServiceResponses.ApplyForEvent;

/**
 * Created by Jam on 24-02-2018.
 */

public class EventApplyResponse {

    String code;
    String message;

    public EventApplyResponse(String code, String message) {
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
