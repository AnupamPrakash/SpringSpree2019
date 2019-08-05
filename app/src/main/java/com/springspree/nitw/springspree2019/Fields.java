
package com.springspree.nitw.springspree2019;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fields implements Serializable {

    @SerializedName("event_type")
    @Expose
    private String eventType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("category1")
    @Expose
    private String category1;
    @SerializedName("category2")
    @Expose
    private Object category2;
    @SerializedName("logo")
    @Expose
    private String logo;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public Object getCategory2() {
        return category2;
    }

    public void setCategory2(Object category2) {
        this.category2 = category2;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
