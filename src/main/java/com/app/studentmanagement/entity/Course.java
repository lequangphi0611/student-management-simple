package com.app.studentmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "nvarchar(50)")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @ManyToMany
    @JoinTable (
        name = "course_student",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Student> students = new ArrayList<>();

    @ManyToMany
    @JoinTable (
        name = "course_subject",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Subject> subjects = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Course() {}

    public Course(long id, String name, Date beginDate, Date endDate, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.teacher = teacher;
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

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}