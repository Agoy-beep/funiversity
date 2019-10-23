package com.arnegoyvaerts.domain;

public class Course {

    private String id;
    private final String name;
    private final int studyPoints;
    private final String professorId;

    public Course(String name, int studyPoints, String professorId) {
        this.name = name;
        this.professorId = professorId;
        if(studyPoints > 1 && studyPoints < 6){
            this.studyPoints = studyPoints;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public String getProfessorId() {
        return professorId;
    }
}
