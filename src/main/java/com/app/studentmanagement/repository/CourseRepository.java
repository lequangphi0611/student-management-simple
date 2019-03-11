package com.app.studentmanagement.repository;

import com.app.studentmanagement.entity.Course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    
}