package com.jam.teachforindia.Fragments.Home;

/**
 * Created by Jam on 22-02-2018.
 */

public class BannerPojo {

    private String bannerid;
    private String bannerpath;
    private String bannerdescription;

    public BannerPojo(String bannerid, String bannerpath, String bannerdescription) {
        this.bannerid = bannerid;
        this.bannerpath = bannerpath;
        this.bannerdescription = bannerdescription;
    }

    public String getBannerid() {
        return bannerid;
    }

    public void setBannerid(String bannerid) {
        this.bannerid = bannerid;
    }

    public String getBannerpath() {
        return bannerpath;
    }

    public void setBannerpath(String bannerpath) {
        this.bannerpath = bannerpath;
    }

    public String getBannerdescription() {
        return bannerdescription;
    }

    public void setBannerdescription(String bannerdescription) {
        this.bannerdescription = bannerdescription;
    }
}
