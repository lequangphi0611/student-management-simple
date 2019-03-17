package com.app.studentmanagement.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.entity.Subject;
import com.app.studentmanagement.exception.IdExistsException;
import com.app.studentmanagement.exception.NameExistsException;
import com.app.studentmanagement.repository.SubjectRepository;
import com.app.studentmanagement.service.SubjectService;
import com.app.studentmanagement.util.CollectionSupport;
import com.app.studentmanagement.util.impl.SubjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private CollectionSupport<Subject, SubjectDTO> collectionSupport;

    @Override
    public SubjectDTO insert(SubjectDTO subjectDTO) {
        if (subjectRepository.existsByName(subjectDTO.getName())) {
            throw new NameExistsException(Subject.class, subjectDTO.getName(), true);
        }
        subjectRepository.save(subjectMapper.parseEntity(subjectDTO));
        return subjectDTO;
    }

    @Override
    public SubjectDTO update(SubjectDTO subjectDTO) {
        if (!subjectRepository.existsById(subjectDTO.getId())) {
            throw new IdExistsException(Subject.class, subjectDTO.getId(), false);
        }
        if (subjectRepository.existsByName(subjectDTO.getName())) {
            Subject oldSubject = subjectRepository.findById(subjectDTO.getId()).get();
            if (!oldSubject.getName().equalsIgnoreCase(subjectDTO.getName())) {
                throw new NameExistsException(Subject.class, subjectDTO.getName(), true);
            }
        }
        Subject subject = subjectMapper.parseEntity(subjectDTO);
        subject.setId(subjectDTO.getId());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public Iterable<SubjectDTO> getAll() {
        List<SubjectDTO> subjects = collectionSupport.convert(subjectRepository.findAll(), subjectMapper::parseDTO);
        Collections.sort(subjects);
        return subjects;
    }

    @Override
    public void deleteById(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectDTO getByID(long id) {
        return subjectMapper.parseDTO(subjectRepository.findById(id).get());
    }

    @Override
    public List<SubjectDTO> getAllByIDArrays(Long[] ids) {
        List<SubjectDTO> subjects = new ArrayList<>();
        for (long id : ids) {
            subjects.add(getByID(id));
        }
        return subjects;
    }

}