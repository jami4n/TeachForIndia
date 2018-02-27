package com.jam.teachforindia.RetroServices.ServiceResponses.Titles;

/**
 * Created by Jam on 26-02-2018.
 */

public class TitlesData {

    String titleid;
    String title;

    public TitlesData(String titleid, String title) {
        this.titleid = titleid;
        this.title = title;
    }

    public String getTitleid() {
        return titleid;
    }

    public void setTitleid(String titleid) {
        this.titleid = titleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
