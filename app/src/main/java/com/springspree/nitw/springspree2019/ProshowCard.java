package com.springspree.nitw.springspree2019;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProshowCard {
    @SerializedName("imaageurl")
    @Expose
    private String imaageurl;
    @SerializedName("name")
    @Expose
    private String name;
    public ProshowCard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImaageurl() {
        return imaageurl;
    }

    public void setImaageurl(String imaageurl) {
        this.imaageurl = imaageurl;
    }

}
