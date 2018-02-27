package com.jam.teachforindia.RetroServices.ServiceResponses.getNotifications;

import java.util.ArrayList;

/**
 * Created by Jam on 25-02-2018.
 */

public class NotificationsResponse {
    String code;
    String message;
    ArrayList<NotificationsData> data;

    public NotificationsResponse(String code, String message, ArrayList<NotificationsData> data) {
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

    public ArrayList<NotificationsData> getData() {
        return data;
    }

    public void setData(ArrayList<NotificationsData> data) {
        this.data = data;
    }
}
