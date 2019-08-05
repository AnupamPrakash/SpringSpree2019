
package com.springspree.nitw.springspree2019.Core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("priority")
    @Expose
    private Integer priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
