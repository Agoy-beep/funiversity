package com.arnegoyvaerts.api.dtos;

import com.arnegoyvaerts.domain.Professor;

public class CourseDto {

    private String id;
    private String name;
    private int studyPoints;
    private Professor professor;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public CourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CourseDto setProfessor(Professor professor) {
        this.professor = professor;
        return this;
    }
}
