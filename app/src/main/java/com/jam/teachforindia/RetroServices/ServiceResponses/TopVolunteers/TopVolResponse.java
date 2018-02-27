package com.jam.teachforindia.RetroServices.ServiceResponses.TopVolunteers;

import java.util.ArrayList;

/**
 * Created by Jam on 26-02-2018.
 */

public class TopVolResponse {

    String code;
    String message;
    ArrayList<VolunteerData> data;

    public TopVolResponse(String code, String message, ArrayList<VolunteerData> data) {
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

    public ArrayList<VolunteerData> getData() {
        return data;
    }

    public void setData(ArrayList<VolunteerData> data) {
        this.data = data;
    }
}
