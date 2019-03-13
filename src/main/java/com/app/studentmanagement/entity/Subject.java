package com.app.studentmanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private Set<Scores> allScores = new HashSet<>();

    @ManyToMany(
        mappedBy = "subjects",
        fetch = FetchType.LAZY)
    Set<Course> courses = new HashSet<>();

    public Subject() {
    }

    public Subject(long id, String name, Set<Scores> allScores, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.allScores = allScores;
        this.courses = courses;
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

    public Set<Scores> getAllScores() {
        return this.allScores;
    }

    public void setAllScores(Set<Scores> allScores) {
        this.allScores = allScores;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Subject id(long id) {
        this.id = id;
        return this;
    }

    public Subject name(String name) {
        this.name = name;
        return this;
    }
}