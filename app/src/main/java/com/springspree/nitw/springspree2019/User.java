package com.springspree.nitw.springspree2019;


/**
 * Created by ANUPAM PRAKASH on 29-01-2019.
 */

public class User {

    private String Firstname,Lastname,Email;

    public User(String firstname, String lastname, String email) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return Email;
    }
}
