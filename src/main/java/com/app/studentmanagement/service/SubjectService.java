package com.app.studentmanagement.service;

import com.app.studentmanagement.dto.SubjectDTO;

public interface SubjectService {

    SubjectDTO insert(SubjectDTO subjectDTO);

    SubjectDTO update(SubjectDTO subjectDTO);

    Iterable<SubjectDTO> getAll();
}