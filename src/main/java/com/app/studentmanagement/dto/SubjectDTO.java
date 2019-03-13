package com.app.studentmanagement.dto;

import java.util.HashSet;
import java.util.Set;

public class SubjectDTO {

    private long id;
    private String name;
    private Set<ScoresDTO> allScores = new HashSet<>();
    private Set<CourseDTO> courses = new HashSet<>();

    public SubjectDTO() {
    }

    public SubjectDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubjectDTO(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ScoresDTO> getAllScores() {
        return this.allScores;
    }

    public void setAllScores(Set<ScoresDTO> allScores) {
        this.allScores = allScores;
    }

    public Set<CourseDTO> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<CourseDTO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return this.name;
    }

}