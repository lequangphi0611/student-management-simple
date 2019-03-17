package com.app.studentmanagement.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.entity.Course;
import com.app.studentmanagement.entity.CourseSubject;
import com.app.studentmanagement.entity.CourseSubjectID;
import com.app.studentmanagement.repository.CourseRepository;
import com.app.studentmanagement.repository.CourseSubjectRepository;
import com.app.studentmanagement.service.CourseService;
import com.app.studentmanagement.util.impl.CourseMapper;
import com.app.studentmanagement.util.impl.SubjectMapper;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired CourseRepository courseRepository;
	
	@Autowired CourseMapper courseMapper;
	
	@Autowired CourseSubjectRepository courseSubjectRepository;
	
	@Autowired SubjectMapper subjectmapper;

	@Override
	public CourseDTO insert(CourseDTO course) {
		Course courseAfterSave = courseRepository.save(courseMapper.parseEntity(course));
		
		CourseSubject courseSubject = new CourseSubject();
		CourseSubjectID courseSubjectID = new CourseSubjectID();
		courseSubjectID.setCourseID(courseAfterSave.getId());
		
		course.getSubjectDTOs().forEach((subjectItem) -> {
			courseSubjectID.setSubjectID(subjectItem.getId());
			courseSubject.setId(courseSubjectID);
			courseSubjectRepository.save(courseSubject);
		});
		
		
		return courseMapper.parseDTO(courseAfterSave);
	}

	@Override
	public CourseDTO update(CourseDTO course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByID(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CourseDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
