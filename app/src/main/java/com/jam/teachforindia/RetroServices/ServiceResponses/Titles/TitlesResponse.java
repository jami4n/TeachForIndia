package com.jam.teachforindia.RetroServices.ServiceResponses.Titles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Jam on 26-02-2018.
 */

public class TitlesResponse {

    String code;
    String message;

    @SerializedName("data")
    ArrayList<TitlesData> titles;

    public TitlesResponse(String code, String message, ArrayList<TitlesData> titles) {
        this.code = code;
        this.message = message;
        this.titles = titles;
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

    public ArrayList<TitlesData> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<TitlesData> titles) {
        this.titles = titles;
    }
}
