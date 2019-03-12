package com.app.studentmanagement.util.impl;

import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.entity.Subject;
import com.app.studentmanagement.util.Mapper;

import org.springframework.stereotype.Component;

@Component
public class SubjectMapper implements Mapper<Subject, SubjectDTO> {

    @Override
    public SubjectDTO parseDTO(Subject entity) {
        return new SubjectDTO(entity.getId(), entity.getName());
    }

    @Override
    public Subject parseEntity(SubjectDTO dto) {
        return new Subject(dto.getName());
    }
    
}