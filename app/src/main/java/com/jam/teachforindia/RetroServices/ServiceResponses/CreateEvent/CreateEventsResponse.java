package com.jam.teachforindia.RetroServices.ServiceResponses.CreateEvent;

import java.util.ArrayList;

/**
 * Created by Jam on 22-02-2018.
 */

public class CreateEventsResponse {
    String code;
    String message;
    EventsData events;

    public CreateEventsResponse(String code, String message, EventsData events) {
        this.code = code;
        this.message = message;
        this.events = events;
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

    public EventsData getEvents() {
        return events;
    }

    public void setEvents(EventsData events) {
        this.events = events;
    }
}
