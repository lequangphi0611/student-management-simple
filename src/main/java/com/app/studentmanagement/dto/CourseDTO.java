package com.app.studentmanagement.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CourseDTO
 */
public class CourseDTO {

    private long id;
    private String name;
    private Date beginDate;
    private Date endDate;
    private TeacherDTO teacher;
    private Set<SubjectDTO> subjectDTOs = new HashSet<>();
    private Set<StudentDTO> studentDTOs = new HashSet<>();

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

    public Set<SubjectDTO> getSubjectDTOs() {
        return this.subjectDTOs;
    }

    public void setSubjectDTOs(Set<SubjectDTO> subjectDTOs) {
        this.subjectDTOs = subjectDTOs;
    }

    public Set<StudentDTO> getStudentDTOs() {
        return this.studentDTOs;
    }

    public void setStudentDTOs(Set<StudentDTO> studentDTOs) {
        this.studentDTOs = studentDTOs;
    }

}