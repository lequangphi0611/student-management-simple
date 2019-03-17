package com.app.studentmanagement.service;

import java.util.List;

import com.app.studentmanagement.dto.SubjectDTO;

public interface SubjectService {

    SubjectDTO insert(SubjectDTO subjectDTO);

    SubjectDTO update(SubjectDTO subjectDTO);

    Iterable<SubjectDTO> getAll();

    void deleteById(long id);

    SubjectDTO getByID(long id);

    List<SubjectDTO> getAllByIDArrays(Long[] ids);
}