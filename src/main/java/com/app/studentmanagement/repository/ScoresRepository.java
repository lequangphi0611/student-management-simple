package com.app.studentmanagement.repository;

import com.app.studentmanagement.entity.Scores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoresRepository extends CrudRepository<Scores, Long> {

    
}