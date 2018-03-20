package com.example.user.myradio.model;

/**
 * Created by User on 25/06/2017.
 */

public class Station {
    private String stationTitle;
    private String imgUri;
    final String DRAWABLE = "drawable/";

    public Station(String stationTitle, String imgUri) {
        this.stationTitle = stationTitle;
        this.imgUri = imgUri;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImgUri() {
        return DRAWABLE+imgUri;
    }
}
