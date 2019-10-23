package com.arnegoyvaerts.domain;

import java.util.*;

public class CourseRepository {

    private Map<String,Course> courseDb;

    public CourseRepository() {
        this.courseDb = new HashMap<String, Course>();
    }

    public void addCourseToDataBase(Course courseToAdd){
        courseDb.put(courseToAdd.getId(), courseToAdd);
    }

    public Course getCoursesWithSameStudyPoints(String studyPoint){
        Course foundCourse = courseDb.get(studyPoint);
        if(foundCourse == null){
            throw new NoSuchElementException();
        }
        else{
            return foundCourse;
        }
    }

    public List<Course> getAllCourses(){
        return new ArrayList<Course>(courseDb.values());
    }
}
