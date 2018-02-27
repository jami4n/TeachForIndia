package com.jam.teachforindia.RetroServices.ServiceResponses.SetTitles;

/**
 * Created by Jam on 26-02-2018.
 */

public class SetTitlesResponse {

    String code;
    String message;
    String data;

    public SetTitlesResponse(String code, String message, String data) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
