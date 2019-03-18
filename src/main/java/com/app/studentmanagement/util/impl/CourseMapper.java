package com.app.studentmanagement.util.impl;

import org.springframework.stereotype.Component;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.entity.Course;
import com.app.studentmanagement.util.Mapper;

@Component
public class CourseMapper implements Mapper<Course, CourseDTO> {
	
	final SubjectMapper subjectMapper = new SubjectMapper();

	final TeacherMapper teacherMapper = new TeacherMapper();
	
	@Override
	public CourseDTO parseDTO(Course entity) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(entity.getId());
		courseDTO.setName(entity.getName());
		courseDTO.setTeacher(teacherMapper.parseDTO(entity.getTeacher()));
		courseDTO.setBeginDate(entity.getBeginDate());
		courseDTO.setEndDate(entity.getEndDate());
		return courseDTO;
	}

	public CourseDTO parseDTOAndFetchSubjects(Course entity) {
		CourseDTO courseDTO = parseDTO(entity);
		entity.getCourseSubjects().forEach(
			(courseSubjectItem) -> {
				courseDTO.getSubjectDTOs().add(subjectMapper.parseDTO(courseSubjectItem.getSubject()));
			}
		);
		return courseDTO;
	}

	@Override
	public Course parseEntity(CourseDTO dto) {
		Course course = new Course();
		course.setName(dto.getName());
		course.setBeginDate(dto.getBeginDate());
		course.setEndDate(dto.getEndDate());
		course.setTeacher(teacherMapper.parseEntity(dto.getTeacher()));
		return course;
	}

}
