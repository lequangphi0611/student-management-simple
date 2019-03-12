package com.app.studentmanagement.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.studentmanagement.dto.TeacherDTO;
import com.app.studentmanagement.repository.TeacherRepository;
import com.app.studentmanagement.service.TeacherService;
import com.app.studentmanagement.util.impl.TeacherMapper;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public Iterable<TeacherDTO> getAll() {
		Set<TeacherDTO> teacherDTOs = new HashSet<>();
		teacherRepository.findAll()
			.forEach(teacher -> teacherDTOs.add(teacherMapper.parseDTO(teacher)));
		return teacherDTOs;
	}

	@Override
	public TeacherDTO insert(TeacherDTO newTeacherDTO) {
		teacherRepository.save(teacherMapper.parseEntity(newTeacherDTO));
		return newTeacherDTO;
	}

	@Override
	public TeacherDTO update(TeacherDTO newTeacherDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
