package com.app.studentmanagement.repository;

import com.app.studentmanagement.entity.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    
}