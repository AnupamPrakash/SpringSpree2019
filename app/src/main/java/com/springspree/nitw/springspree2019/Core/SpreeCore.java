
package com.springspree.nitw.springspree2019.Core;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpreeCore {

    @SerializedName("Member")
    @Expose
    private List<Member> member = null;
    @SerializedName("Team")
    @Expose
    private List<Team> team = null;

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

}
