
package com.springspree.nitw.springspree2019.Core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("team")
    @Expose
    private Integer team;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("linkedin")
    @Expose
    private String linkedin;
    @SerializedName("facebook_link")
    @Expose
    private String facebookLink;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("priority")
    @Expose
    private Integer priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
