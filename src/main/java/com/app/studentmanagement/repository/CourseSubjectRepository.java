package com.app.studentmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.studentmanagement.entity.CourseSubject;
import com.app.studentmanagement.entity.CourseSubjectID;

@Repository
public interface CourseSubjectRepository extends CrudRepository<CourseSubject, CourseSubjectID> {

}
