
package com.springspree.nitw.springspree2019.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("pk")
    @Expose
    private Integer pk;
    @SerializedName("fields")
    @Expose
    private Fields__ fields;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Fields__ getFields() {
        return fields;
    }

    public void setFields(Fields__ fields) {
        this.fields = fields;
    }

}
