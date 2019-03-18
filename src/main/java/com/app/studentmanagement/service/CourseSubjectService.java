package com.app.studentmanagement.service;

import java.util.Collection;

import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.entity.CourseSubject;

/**
 * CourseSubjectService
 */
public interface CourseSubjectService {

    Iterable<CourseSubject> insertAll(long courseID, Collection<SubjectDTO> subjects);

}