package com.app.studentmanagement.repository;

import com.app.studentmanagement.entity.Teacher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	boolean existsByEmail(String email);
	
	boolean existsByPhone(String phone);
    
}