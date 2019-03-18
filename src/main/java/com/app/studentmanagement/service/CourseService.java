package com.app.studentmanagement.service;

import com.app.studentmanagement.dto.CourseDTO;

/**
 * CourseService
 */
public interface CourseService {

    CourseDTO insert(CourseDTO course);

    CourseDTO update(CourseDTO course);

    boolean deleteByID(Long id);

    Iterable<CourseDTO> getAllAndFetchSubjects();
    
}