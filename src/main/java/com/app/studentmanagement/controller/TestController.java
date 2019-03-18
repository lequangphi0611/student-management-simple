package com.app.studentmanagement.controller;

import java.util.List;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
public class TestController {

    @Autowired CourseService courseService;

    @GetMapping("/ooopp")
    public List<CourseDTO> tess() {
        return (List<CourseDTO>)courseService.getAllAndFetchSubjects();
    }

    
}