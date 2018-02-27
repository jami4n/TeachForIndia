package com.jam.teachforindia.RetroServices.ServiceResponses.SaveRegistrationResponse;

/**
 * Created by Jam on 27-02-2018.
 */

public class SaveRegResponse {

    String code;
    String message;

    public SaveRegResponse(String code, String message) {
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
