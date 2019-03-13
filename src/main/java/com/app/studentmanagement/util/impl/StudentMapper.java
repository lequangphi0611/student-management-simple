package com.app.studentmanagement.util.impl;

import com.app.studentmanagement.dto.StudentDTO;
import com.app.studentmanagement.entity.Student;
import com.app.studentmanagement.util.Mapper;

/**
 * StudentMapper
 */
public class StudentMapper implements Mapper<Student, StudentDTO> {

    private final PersonMapper personMapper = new PersonMapper();

    @Override
    public StudentDTO parseDTO(Student entity) {
        return new StudentDTO(personMapper.parseDTO(entity));
    }

    @Override
    public Student parseEntity(StudentDTO dto) {
        return new Student(personMapper.parseEntity(dto));
    }

}