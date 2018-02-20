package com.jam.teachforindia.RetroServices.ServiceResponses.Login;

import java.util.ArrayList;

/**
 * Created by Jam on 21-02-2018.
 */

public class LoginResponse {

    String code;
    String message;
    ArrayList<LoginData> data;

    public LoginResponse(String code, String message, ArrayList<LoginData> data) {
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

    public ArrayList<LoginData> getData() {
        return data;
    }

    public void setData(ArrayList<LoginData> data) {
        this.data = data;
    }
}
