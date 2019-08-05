
package com.springspree.nitw.springspree2019.Details;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

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
    private String category2;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("rounds")
    @Expose
    private Integer rounds;
    @SerializedName("min_team_size")
    @Expose
    private Integer minTeamSize;
    @SerializedName("max_team_size")
    @Expose
    private Integer maxTeamSize;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("is_published")
    @Expose
    private Boolean isPublished;
    @SerializedName("venue")
    @Expose
    private Object venue;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("event_time")
    @Expose
    private Object eventTime;
    @SerializedName("nitw_discount")
    @Expose
    private Double nitwDiscount;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("prize")
    @Expose
    private String prize;
    @SerializedName("group_fee_threshold")
    @Expose
    private Integer groupFeeThreshold;
    @SerializedName("group_fee")
    @Expose
    private Double groupFee;
    @SerializedName("contents")
    @Expose
    private List<Integer> contents = null;
    @SerializedName("contact_members")
    @Expose
    private List<Integer> contactMembers = null;

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

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Integer getMinTeamSize() {
        return minTeamSize;
    }

    public void setMinTeamSize(Integer minTeamSize) {
        this.minTeamSize = minTeamSize;
    }

    public Integer getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(Integer maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Object getVenue() {
        return venue;
    }

    public void setVenue(Object venue) {
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Object getEventTime() {
        return eventTime;
    }

    public void setEventTime(Object eventTime) {
        this.eventTime = eventTime;
    }

    public Double getNitwDiscount() {
        return nitwDiscount;
    }

    public void setNitwDiscount(Double nitwDiscount) {
        this.nitwDiscount = nitwDiscount;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Integer getGroupFeeThreshold() {
        return groupFeeThreshold;
    }

    public void setGroupFeeThreshold(Integer groupFeeThreshold) {
        this.groupFeeThreshold = groupFeeThreshold;
    }

    public Double getGroupFee() {
        return groupFee;
    }

    public void setGroupFee(Double groupFee) {
        this.groupFee = groupFee;
    }

    public List<Integer> getContents() {
        return contents;
    }

    public void setContents(List<Integer> contents) {
        this.contents = contents;
    }

    public List<Integer> getContactMembers() {
        return contactMembers;
    }

    public void setContactMembers(List<Integer> contactMembers) {
        this.contactMembers = contactMembers;
    }

}
