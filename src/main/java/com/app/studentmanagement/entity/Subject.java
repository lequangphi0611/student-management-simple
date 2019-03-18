package com.app.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "nvarchar(50)", unique = true, nullable = false)
    private String name;

    @OneToMany(
        mappedBy = "subject",
        fetch = FetchType.LAZY)
    private List<Scores> allScores = new ArrayList<>();

    @OneToMany(
        mappedBy = "subject",
        fetch = FetchType.LAZY)
    List<CourseSubject> courseSubjects = new ArrayList<>();

    public Subject() {
    }

    public Subject(long id, String name, List<Scores> allScores, List<CourseSubject> courseSubjects) {
        this.id = id;
        this.name = name;
        this.allScores = allScores;
        this.courseSubjects = courseSubjects;
    }

    public Subject(String name) {
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

    public List<Scores> getAllScores() {
        return this.allScores;
    }

    public void setAllScores(List<Scores> allScores) {
        this.allScores = allScores;
    }

    public List<CourseSubject> getCourseSubjects() {
        return this.courseSubjects;
    }

    public void setCourseSubjects(List<CourseSubject> courseSubjects) {
        this.courseSubjects = courseSubjects;
    }
}