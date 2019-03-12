package com.app.studentmanagement.util.impl;

import org.springframework.stereotype.Component;

import com.app.studentmanagement.dto.TeacherDTO;
import com.app.studentmanagement.entity.Teacher;
import com.app.studentmanagement.util.Mapper;

@Component
public class TeacherMapper implements Mapper<Teacher, TeacherDTO> {
	
	private final PersonMapper personMapper = new PersonMapper();

	@Override
	public TeacherDTO parseDTO(Teacher entity) {
		return new TeacherDTO(personMapper.parseDTO(entity), entity.getEmail(), entity.getPhone());
	}

	@Override
	public Teacher parseEntity(TeacherDTO dto) {
		return new Teacher(personMapper.parseEntity(dto), dto.getEmail(), dto.getPhone());
	}

}
