package com.app.studentmanagement.service;

import com.app.studentmanagement.dto.TeacherDTO;

/**
 * TeacherService
 */
public interface TeacherService {
	
	Iterable<TeacherDTO> getAll();

	TeacherDTO insert(TeacherDTO newTeacherDTO);
	
	TeacherDTO update(TeacherDTO newTeacherDTO);
    
}