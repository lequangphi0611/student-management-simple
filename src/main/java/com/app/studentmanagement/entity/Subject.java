package com.app.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column(
        columnDefinition = "nvarchar(50)",
        unique = true,
        nullable = false
    )
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Scores> allScores = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    List<Course> courses = new ArrayList<>();
}