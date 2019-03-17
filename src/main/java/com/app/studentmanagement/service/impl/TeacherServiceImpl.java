package com.app.studentmanagement.service.impl;

import com.app.studentmanagement.dto.TeacherDTO;
import com.app.studentmanagement.entity.Teacher;
import com.app.studentmanagement.exception.EmailExistsException;
import com.app.studentmanagement.exception.IdExistsException;
import com.app.studentmanagement.exception.PhoneExistsException;
import com.app.studentmanagement.repository.TeacherRepository;
import com.app.studentmanagement.service.TeacherService;
import com.app.studentmanagement.util.CollectionSupport;
import com.app.studentmanagement.util.impl.TeacherMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private CollectionSupport<Teacher, TeacherDTO> collectionSupport;
	
	@Override
	public Iterable<TeacherDTO> getAll() {
		return collectionSupport.convert(teacherRepository.findAll(), teacherMapper::parseDTO);
	}

	@Override
	public TeacherDTO insert(TeacherDTO newTeacherDTO) {
		if(teacherRepository.existsByEmail(newTeacherDTO.getEmail())) {
			throw new EmailExistsException(newTeacherDTO.getEmail());
		}
		
		if(teacherRepository.existsByPhone(newTeacherDTO.getPhone())) {
			throw new PhoneExistsException(newTeacherDTO.getPhone());
		}
		
		teacherRepository.save(teacherMapper.parseEntity(newTeacherDTO));
		return newTeacherDTO;
	}

	@Override
	public TeacherDTO update(TeacherDTO newTeacherDTO) {
		if(!teacherRepository.existsById(newTeacherDTO.getId())) {
			throw new IdExistsException(Teacher.class, newTeacherDTO.getId(), false);
		}
		
		Teacher oldTeacher = null;
		if (teacherRepository.existsByEmail(newTeacherDTO.getEmail())) {
			oldTeacher = teacherRepository.findById(newTeacherDTO.getId()).get();
			if(!oldTeacher.getEmail().equals(newTeacherDTO.getEmail())) {
				throw new EmailExistsException(oldTeacher.getEmail());
			}
		}
		
		if(teacherRepository.existsByPhone(newTeacherDTO.getPhone())) {
			oldTeacher = teacherRepository.findById(newTeacherDTO.getId()).get();
			if(!oldTeacher.getPhone().equals(newTeacherDTO.getPhone())) {
				throw new PhoneExistsException(newTeacherDTO.getPhone());
			}
		}
		
		teacherRepository.save(teacherMapper.parseEntity(newTeacherDTO));
		return newTeacherDTO;
	}

	@Override
	public TeacherDTO getByID(long id) {
		return teacherMapper.parseDTO(teacherRepository.findById(id).get());
	}

}
