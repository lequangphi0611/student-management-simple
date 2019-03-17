package com.app.studentmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.studentmanagement.dto.CourseDTO;
import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.service.CourseService;
import com.app.studentmanagement.service.SubjectService;
import com.app.studentmanagement.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * CourseController
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    // View
    static final String COURSE_FORM_VIEW_PATH = "course/course_form";

    // attribute name
    static final String ALL_SUBJECT_ATTRIBUTE_NAME = "subjects";
    static final String ALL_TEACHER_ATTRIBUTE_NAME = "teachers";
    static final String COURSE_ATTRIBUTE_NAME = "course";

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    final Map<String, Object> getCourseFormAttribute() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(ALL_SUBJECT_ATTRIBUTE_NAME, subjectService.getAll());
        attributes.put(ALL_TEACHER_ATTRIBUTE_NAME, teacherService.getAll());
        return attributes;
    }

    @GetMapping(value = "/add")
    public String displatCourseForm(ModelMap model) {
        model.addAllAttributes(getCourseFormAttribute());
        model.addAttribute(COURSE_ATTRIBUTE_NAME, new CourseDTO());
        return COURSE_FORM_VIEW_PATH;
    }

    @PostMapping(value = "/add")
    public String processAddAction(@ModelAttribute CourseDTO course, @RequestParam("subject") Long[] subjectIDs,
            @RequestParam long teacherID) {
        List<SubjectDTO> subjects = new ArrayList<>();
        for(long id : subjectIDs) {
        	SubjectDTO subjectTemp = new SubjectDTO();
        	subjectTemp.setId(id);
        	subjects.add(subjectTemp);
        }
    	
    	course.setTeacher(teacherService.getByID(teacherID));        
        course.setSubjectDTOs(subjects);
        
        courseService.insert(course);
        
        return "redirect:/course/add";
    }

}