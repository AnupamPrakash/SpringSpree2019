package com.springspree.nitw.springspree2019.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

    @SerializedName("venue_name")
    @Expose
    private String venueName;
    @SerializedName("venue_lat")
    @Expose
    private String venueLat;
    @SerializedName("venue_longt")
    @Expose
    private String venueLongt;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLat() {
        return venueLat;
    }

    public void setVenueLat(String venueLat) {
        this.venueLat = venueLat;
    }

    public String getVenueLongt() {
        return venueLongt;
    }

    public void setVenueLongt(String venueLongt) {
        this.venueLongt = venueLongt;
    }

}
