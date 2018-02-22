package com.jam.teachforindia.RetroServices.ServiceResponses.GetEvents;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jam on 22-02-2018.
 */

public class EventsResponse {

    String code;
    String message;
    ArrayList<EventsData> data;

    public EventsResponse(String code, String message, ArrayList<EventsData> data) {
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

    public ArrayList<EventsData> getData() {
        return data;
    }

    public void setData(ArrayList<EventsData> data) {
        this.data = data;
    }
}
