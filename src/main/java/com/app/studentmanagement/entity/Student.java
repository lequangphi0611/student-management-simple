package com.app.studentmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {

    @ManyToMany(
        mappedBy = "students",
        fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>(); 
    
    @OneToMany(
        mappedBy = "student", 
        fetch = FetchType.LAZY)
    private List<Scores> allScores = new ArrayList<>();

    public Student() { super(); }

    public Student(long id, String name, boolean gender, Date birthday, boolean status) {
        super(id, name, gender, birthday, status);
    }

    public Student (Person person1) {
        super(person1);
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Scores> getAllScores() {
        return this.allScores;
    }

    public void setAllScores(List<Scores> allScores) {
        this.allScores = allScores;
    }


}