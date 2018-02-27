package com.jam.teachforindia.Fragments.Notifications;

/**
 * Created by Jam on 25-02-2018.
 */

public class NotificationPojo {

    String Notificationbody;
    String Notificationtitle;
    String Notificationid;
    String Notificationread;

    public NotificationPojo(String notificationbody, String notificationtitle, String notificationid, String notificationread) {
        Notificationbody = notificationbody;
        Notificationtitle = notificationtitle;
        Notificationid = notificationid;
        Notificationread = notificationread;
    }

    public String getNotificationbody() {
        return Notificationbody;
    }

    public void setNotificationbody(String notificationbody) {
        Notificationbody = notificationbody;
    }

    public String getNotificationtitle() {
        return Notificationtitle;
    }

    public void setNotificationtitle(String notificationtitle) {
        Notificationtitle = notificationtitle;
    }

    public String getNotificationid() {
        return Notificationid;
    }

    public void setNotificationid(String notificationid) {
        Notificationid = notificationid;
    }

    public String getNotificationread() {
        return Notificationread;
    }

    public void setNotificationread(String notificationread) {
        Notificationread = notificationread;
    }
}
