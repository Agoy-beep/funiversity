package com.arnegoyvaerts.domain;

public class Course {

    private String id;
    private final String name;
    private final int studyPoints;
    private final Professor professor;

    public Course(String name, int studyPoints, Professor professor) {
        this.name = name;
        this.studyPoints = studyPoints;
        this.professor = professor;
    }

}
