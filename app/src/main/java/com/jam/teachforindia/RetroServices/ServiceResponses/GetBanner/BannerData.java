package com.jam.teachforindia.RetroServices.ServiceResponses.GetBanner;

/**
 * Created by Jam on 22-02-2018.
 */

public class BannerData {
    String bannerid;
    String bannerdescription;
    String bannerimagepath;

    public BannerData(String bannerid, String bannerdescription, String bannerimagepath) {
        this.bannerid = bannerid;
        this.bannerdescription = bannerdescription;
        this.bannerimagepath = bannerimagepath;
    }

    public String getBannerid() {
        return bannerid;
    }

    public void setBannerid(String bannerid) {
        this.bannerid = bannerid;
    }

    public String getBannerdescription() {
        return bannerdescription;
    }

    public void setBannerdescription(String bannerdescription) {
        this.bannerdescription = bannerdescription;
    }

    public String getBannerimagepath() {
        return bannerimagepath;
    }

    public void setBannerimagepath(String bannerimagepath) {
        this.bannerimagepath = bannerimagepath;
    }
}
