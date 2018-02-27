package com.jam.teachforindia.RetroServices.ServiceResponses.GetScore;

/**
 * Created by Jam on 26-02-2018.
 */

public class ScoreResponse {
    String code;
    String message;
    String score;

    public ScoreResponse(String code, String message, String score) {
        this.code = code;
        this.message = message;
        this.score = score;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
