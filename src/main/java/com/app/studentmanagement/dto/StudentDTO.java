package com.app.studentmanagement.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * StudentDTO
 */
public class StudentDTO extends PersonDTO{

    private Set<CourseDTO> courseDTOs = new HashSet<>();
    private Set<ScoresDTO> allScoreDTOs = new HashSet<>();

    public StudentDTO() {
        super();
    }

    public StudentDTO(PersonDTO person1) {
        super(person1);
    }

    public Set<CourseDTO> getCourseDTOs() {
        return this.courseDTOs;
    }

    public void setCourseDTOs(Set<CourseDTO> courseDTOs) {
        this.courseDTOs = courseDTOs;
    }

    public Set<ScoresDTO> getAllScoreDTOs() {
        return this.allScoreDTOs;
    }

    public void setAllScoreDTOs(Set<ScoresDTO> allScoreDTOs) {
        this.allScoreDTOs = allScoreDTOs;
    }

}