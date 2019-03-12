package com.app.studentmanagement.repository;

import com.app.studentmanagement.entity.Subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    boolean existsByName(String name);

}