package com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Jam on 24-02-2018.
 */

public class EventApplicantsResponse {
    String code;
    String message;

    @SerializedName("data")
    ArrayList<ApplicantData> applicantData;

    public EventApplicantsResponse(String code, String message, ArrayList<ApplicantData> applicantData) {
        this.code = code;
        this.message = message;
        this.applicantData = applicantData;
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

    public ArrayList<ApplicantData> getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ArrayList<ApplicantData> applicantData) {
        this.applicantData = applicantData;
    }
}
