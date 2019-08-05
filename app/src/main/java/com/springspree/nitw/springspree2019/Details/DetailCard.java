
package com.springspree.nitw.springspree2019.Details;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailCard {

    @SerializedName("event")
    @Expose
    private Event event;
    @SerializedName("contents")
    @Expose
    private List<Content> contents = null;
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("venue")
    @Expose
    private Venue venue;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
