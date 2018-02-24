package com.jam.teachforindia.RetroServices.ServiceResponses.StaffUpdateApplication;

/**
 * Created by Jam on 25-02-2018.
 */

public class ApplicationUpdateResponse {

    String code;
    String message;

    public ApplicationUpdateResponse(String code, String message) {
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
