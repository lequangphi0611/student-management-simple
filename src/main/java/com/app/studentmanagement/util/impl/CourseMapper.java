package com.app.studentmanagement.util.impl;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.entity.Course;
import com.app.studentmanagement.util.Mapper;

/**
 * CourseMapper
 */
public class CourseMapper implements Mapper<Course, CourseDTO> {

    private final TeacherMapper teacherMapper = new TeacherMapper();

    @Override
    public CourseDTO parseDTO(Course entity) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(entity.getId());
        courseDTO.setName(entity.getName());
        courseDTO.setBeginDate(entity.getBeginDate());
        courseDTO.setEndDate(entity.getEndDate());
        courseDTO.setTeacher(teacherMapper.parseDTO(entity.getTeacher()));
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