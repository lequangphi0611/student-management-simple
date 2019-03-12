package com.app.studentmanagement.dto;


public class SubjectDTO {

    private long id;
    private String name;

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

    @Override
    public String toString() {
        return this.name;
    }

}