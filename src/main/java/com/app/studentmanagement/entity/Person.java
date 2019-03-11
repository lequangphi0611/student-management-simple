package com.app.studentmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
        columnDefinition = "nvarchar(50)",
        nullable = false
    )
    private String name;

    private boolean gender;

    private Date birthday;

    private boolean status;

    public Person () {}

    public Person(long id, String name, boolean gender, Date birthday, boolean status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
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

    public boolean isGender() {
        return this.gender;
    }

    public boolean getGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}