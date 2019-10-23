package com.arnegoyvaerts.api.dtos;

public class UpdateProfessorDto {

    private String id;
    private String firstname;
    private String lastname;

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UpdateProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public UpdateProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UpdateProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
