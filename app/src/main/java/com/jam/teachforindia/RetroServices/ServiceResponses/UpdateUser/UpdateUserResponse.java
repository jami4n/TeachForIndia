package com.jam.teachforindia.RetroServices.ServiceResponses.UpdateUser;

/**
 * Created by Jam on 22-02-2018.
 */

public class UpdateUserResponse {

    String code;
    String message;

    public UpdateUserResponse(String code, String message) {
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
