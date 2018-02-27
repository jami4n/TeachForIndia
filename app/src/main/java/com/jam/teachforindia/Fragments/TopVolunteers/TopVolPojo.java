package com.jam.teachforindia.Fragments.TopVolunteers;

/**
 * Created by Jam on 26-02-2018.
 */

public class TopVolPojo {

    String firstname;
    String title;
    String score;

    public TopVolPojo(String firstname, String title, String score) {
        this.firstname = firstname;
        this.title = title;
        this.score = score;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
