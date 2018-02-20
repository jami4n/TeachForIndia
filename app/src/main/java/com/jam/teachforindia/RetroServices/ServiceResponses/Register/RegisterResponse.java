package com.jam.teachforindia.RetroServices.ServiceResponses.Register;

/**
 * Created by Jam on 21-02-2018.
 */

public class RegisterResponse {

    String code;
    String message;
    RegisterData data;

    public RegisterResponse(String code, String message, RegisterData data) {
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

    public RegisterData getData() {
        return data;
    }

    public void setData(RegisterData data) {
        this.data = data;
    }
}
