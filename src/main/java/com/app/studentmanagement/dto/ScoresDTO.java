package com.app.studentmanagement.dto;

/**
 * ScoresDTO
 */
public class ScoresDTO {

    private long id;
    private int value;
    private SubjectDTO subjectDTO;
    private StudentDTO studentDTO;

    public ScoresDTO() {
    }

    public ScoresDTO(long id, int value, SubjectDTO subjectDTO, StudentDTO studentDTO) {
        this.id = id;
        this.value = value;
        this.subjectDTO = subjectDTO;
        this.studentDTO = studentDTO;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SubjectDTO getSubjectDTO() {
        return this.subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public StudentDTO getStudentDTO() {
        return this.studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

}