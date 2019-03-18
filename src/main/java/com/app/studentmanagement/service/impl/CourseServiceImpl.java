package com.app.studentmanagement.service.impl;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.entity.Course;
import com.app.studentmanagement.repository.CourseRepository;
import com.app.studentmanagement.service.CourseService;
import com.app.studentmanagement.service.CourseSubjectService;
import com.app.studentmanagement.util.CollectionSupport;
import com.app.studentmanagement.util.impl.CourseMapper;
import com.app.studentmanagement.util.impl.SubjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	CourseSubjectService courseSubjectService;

	@Autowired
	SubjectMapper subjectmapper;

	@Autowired
	CollectionSupport<Course, CourseDTO> collectionSupport;

	@Override
	public CourseDTO insert(CourseDTO course) {
		Course courseAfterSave = courseRepository.save(courseMapper.parseEntity(course));

		courseSubjectService.insertAll(courseAfterSave.getId(), course.getSubjectDTOs());

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
	public Iterable<CourseDTO> getAllAndFetchSubjects() {
		return collectionSupport.convert(courseRepository.findAll(), courseMapper::parseDTOAndFetchSubjects);
	}

}
