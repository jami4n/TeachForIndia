package com.jam.teachforindia.RetroServices.ServiceResponses.TopVolunteers;

/**
 * Created by Jam on 26-02-2018.
 */

public class VolunteerData {

    String firstname;
    String userid;
    String score;
    String usertitle;

    public VolunteerData(String firstname, String userid, String score, String usertitle) {
        this.firstname = firstname;
        this.userid = userid;
        this.score = score;
        this.usertitle = usertitle;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUsertitle() {
        return usertitle;
    }

    public void setUsertitle(String usertitle) {
        this.usertitle = usertitle;
    }
}
