package com.app.studentmanagement.dto;

import java.util.Date;

/**
 * PersonDTO
 */
public class PersonDTO {

    private long id;
    private String name;
    private boolean gender;
    private Date birthday;
    private boolean status;

    public PersonDTO() {
    }

    public PersonDTO(long id, String name, boolean gender, Date birthday, boolean status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
    }
    
    public PersonDTO (PersonDTO personDTO1) {
    	this.id = personDTO1.getId();
    	this.name = personDTO1.getName();
    	this.gender = personDTO1.isGender();
    	this.birthday = personDTO1.getBirthday();
    	this.status = personDTO1.isStatus();
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

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}