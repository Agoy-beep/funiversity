package com.arnegoyvaerts.domain;

import java.util.UUID;

public class Professor {

    private String id;
    private final String firstname;
    private final String lastname;

    public Professor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = UUID.randomUUID().toString();
    }


}
