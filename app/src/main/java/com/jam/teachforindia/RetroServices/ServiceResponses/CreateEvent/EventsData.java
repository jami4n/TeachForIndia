package com.jam.teachforindia.RetroServices.ServiceResponses.CreateEvent;

/**
 * Created by Jam on 22-02-2018.
 */

public class EventsData {
    String eventid;
    String eventtitle;
    String eventhead;
    String eventfellow;
    String eventdescription;
    String eventlocation;
    String eventlatlong;
    String eventmaxpoints;
    String eventimage;
    String eventstartdate;
    String eventenddate;

    public EventsData(String eventid, String eventtitle, String eventhead, String eventfellow, String eventdescription, String eventlocation, String eventlatlong, String eventmaxpoints, String eventimage, String eventstartdate, String eventenddate) {
        this.eventid = eventid;
        this.eventtitle = eventtitle;
        this.eventhead = eventhead;
        this.eventfellow = eventfellow;
        this.eventdescription = eventdescription;
        this.eventlocation = eventlocation;
        this.eventlatlong = eventlatlong;
        this.eventmaxpoints = eventmaxpoints;
        this.eventimage = eventimage;
        this.eventstartdate = eventstartdate;
        this.eventenddate = eventenddate;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventhead() {
        return eventhead;
    }

    public void setEventhead(String eventhead) {
        this.eventhead = eventhead;
    }

    public String getEventfellow() {
        return eventfellow;
    }

    public void setEventfellow(String eventfellow) {
        this.eventfellow = eventfellow;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getEventlatlong() {
        return eventlatlong;
    }

    public void setEventlatlong(String eventlatlong) {
        this.eventlatlong = eventlatlong;
    }

    public String getEventmaxpoints() {
        return eventmaxpoints;
    }

    public void setEventmaxpoints(String eventmaxpoints) {
        this.eventmaxpoints = eventmaxpoints;
    }

    public String getEventimage() {
        return eventimage;
    }

    public void setEventimage(String eventimage) {
        this.eventimage = eventimage;
    }

    public String getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(String eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public String getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(String eventenddate) {
        this.eventenddate = eventenddate;
    }
}
