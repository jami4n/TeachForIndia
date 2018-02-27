package com.jam.teachforindia.RetroServices.ServiceResponses.getNotifications;

/**
 * Created by Jam on 25-02-2018.
 */

public class NotificationsData {

    String notificationid;
    String notiftitle;
    String notifbody;
    String userid;
    String notifread;

    public NotificationsData(String notificationid, String notiftitle, String notifbody, String userid, String notifread) {
        this.notificationid = notificationid;
        this.notiftitle = notiftitle;
        this.notifbody = notifbody;
        this.userid = userid;
        this.notifread = notifread;
    }

    public String getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(String notificationid) {
        this.notificationid = notificationid;
    }

    public String getNotiftitle() {
        return notiftitle;
    }

    public void setNotiftitle(String notiftitle) {
        this.notiftitle = notiftitle;
    }

    public String getNotifbody() {
        return notifbody;
    }

    public void setNotifbody(String notifbody) {
        this.notifbody = notifbody;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNotifread() {
        return notifread;
    }

    public void setNotifread(String notifread) {
        this.notifread = notifread;
    }
}
