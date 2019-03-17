package com.app.studentmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email") ,
        @UniqueConstraint(columnNames = "phone")
    }
)
public class Teacher extends Person{

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
    
    @OneToMany(
        mappedBy = "teacher",
        fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    public Teacher() { super(); }

    public Teacher(long id, String name, boolean gender, Date birthday , String email, String phone, boolean status) {
        super(id, name, gender, birthday, status);
        this.email = email;
        this.phone = phone;
    }
    
    public Teacher (Person person, String email, String phone) {
        super(person);
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }    

}