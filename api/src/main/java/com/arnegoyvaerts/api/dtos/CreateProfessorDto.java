package com.arnegoyvaerts.api.dtos;

public class CreateProfessorDto {

    private String firstname;
    private String lastname;


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public CreateProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
