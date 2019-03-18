package com.app.studentmanagement.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.entity.CourseSubject;
import com.app.studentmanagement.entity.CourseSubjectID;
import com.app.studentmanagement.repository.CourseSubjectRepository;
import com.app.studentmanagement.service.CourseSubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CourseSubjectServiceImpl
 */
@Service
public class CourseSubjectServiceImpl implements CourseSubjectService {

    @Autowired
    private CourseSubjectRepository courseSubjectRepository;

    public CourseSubject save(CourseSubjectID courseSubjectID) {
        return courseSubjectRepository.save(new CourseSubject(courseSubjectID));
    }

    @Override
    public Iterable<CourseSubject> insertAll(long courseID, Collection<SubjectDTO> subjects) {
        List<CourseSubject> courseSubjects = new ArrayList<>();

        CourseSubjectID courseSubjectID = new CourseSubjectID();
        courseSubjectID.setCourseID(courseID);

        subjects.forEach((subject) -> {
            courseSubjectID.setSubjectID(subject.getId());
            courseSubjects.add(save(courseSubjectID));
        });
        
        return courseSubjects;
    }

}