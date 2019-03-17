package com.app.studentmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * CourseDTO
 */
public class CourseDTO {

    private long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private TeacherDTO teacher;
    private List<SubjectDTO> subjectDTOs = new ArrayList<>();
    private List<StudentDTO> studentDTOs = new ArrayList<>();

    {
        beginDate = endDate = new Date();
    }

    public CourseDTO() {
    }

    public CourseDTO(long id, String name, Date beginDate, Date endDate, TeacherDTO teacher) {
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

    public TeacherDTO getTeacher() {
        return this.teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public List<SubjectDTO> getSubjectDTOs() {
        return this.subjectDTOs;
    }

    public void setSubjectDTOs(List<SubjectDTO> subjectDTOs) {
        this.subjectDTOs = subjectDTOs;
    }

    public List<StudentDTO> getStudentDTOs() {
        return this.studentDTOs;
    }

    public void setStudentDTOs(List<StudentDTO> studentDTOs) {
        this.studentDTOs = studentDTOs;
    }

}