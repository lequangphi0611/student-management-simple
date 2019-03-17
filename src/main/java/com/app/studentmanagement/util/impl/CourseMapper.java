package com.app.studentmanagement.util.impl;

import org.springframework.stereotype.Component;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.entity.Course;
import com.app.studentmanagement.entity.CourseSubject;
import com.app.studentmanagement.util.Mapper;

@Component
public class CourseMapper implements Mapper<Course, CourseDTO> {
	
	final SubjectMapper subjectMapper = new SubjectMapper();

	final TeacherMapper teacherMapper = new TeacherMapper();
	
	@Override
	public CourseDTO parseDTO(Course entity) {
		// TODO Auto-generated method stub
		return null;
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
