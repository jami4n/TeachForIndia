package com.jam.teachforindia.Fragments.Events;

/**
 * Created by Jam on 22-02-2018.
 */

public class EventsPojo {

    String eventId;
    String eventImage;
    String eventTitle;
    String eventDescription;
    String eventLocation;
    String eventLatLong;
    String eventStartDate;
    String eventEnddate;

    public EventsPojo(String eventId, String eventImage, String eventTitle, String eventDescription, String eventLocation, String eventLatLong, String eventStartDate, String eventEnddate) {
        this.eventId = eventId;
        this.eventImage = eventImage;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.eventLatLong = eventLatLong;
        this.eventStartDate = eventStartDate;
        this.eventEnddate = eventEnddate;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventLatLong() {
        return eventLatLong;
    }

    public void setEventLatLong(String eventLatLong) {
        this.eventLatLong = eventLatLong;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEnddate() {
        return eventEnddate;
    }

    public void setEventEnddate(String eventEnddate) {
        this.eventEnddate = eventEnddate;
    }
}
