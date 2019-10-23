package com.arnegoyvaerts.domain;

import java.util.UUID;

public class Professor {

    private String id;
    private String firstname;
    private String lastname;

    public Professor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
