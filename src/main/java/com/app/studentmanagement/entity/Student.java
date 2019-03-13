package com.app.studentmanagement.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {

    @ManyToMany(
        mappedBy = "students",
        fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>(); 
    
    @OneToMany(
        mappedBy = "student", 
        fetch = FetchType.LAZY)
    private Set<Scores> allScores = new HashSet<>();

    public Student() { super(); }

    public Student(long id, String name, boolean gender, Date birthday, boolean status) {
        super(id, name, gender, birthday, status);
    }

    public Student (Person person1) {
        super(person1);
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Scores> getAllScores() {
        return this.allScores;
    }

    public void setAllScores(Set<Scores> allScores) {
        this.allScores = allScores;
    }


}