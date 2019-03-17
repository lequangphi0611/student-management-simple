package com.app.studentmanagement.controller;

import com.app.studentmanagement.dto.SubjectDTO;
import com.app.studentmanagement.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    // View
    static final String SUBJECT_VIEW_PATH = "subject/subject-management";

    // Attribute Name
    static final String ALL_SUBJECT_ATTRIBUTE = "allSubjects";
    static final String SUBJECT_ATTRIBUTE = "subject";
    static final String ACTION_ATTRIBUTE = "action";

    // Attribute value
    static final String ACTION_ADD_ATTRIBUTE_VALUE = "/subject/add";
    static final String ACTION_EDIT_ATTRIBUTE_VALUE = "/subject/edit";

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = {"", "/add"})
    public String viewPage(ModelMap model) {
        model.addAttribute(ALL_SUBJECT_ATTRIBUTE, subjectService.getAll());
        model.addAttribute(SUBJECT_ATTRIBUTE, new SubjectDTO());
        model.addAttribute(ACTION_ATTRIBUTE, ACTION_ADD_ATTRIBUTE_VALUE);
        return SUBJECT_VIEW_PATH;
    }

    @PostMapping("/add")
    public String processAddSubject(@ModelAttribute SubjectDTO subjectDTO) {
        subjectService.insert(subjectDTO);
        return "redirect:/subject";
    }

    @GetMapping("/edit/{id}")
    public String viewEditStatus(ModelMap model, @PathVariable long id) {
        model.addAttribute(ALL_SUBJECT_ATTRIBUTE, subjectService.getAll());
        model.addAttribute(SUBJECT_ATTRIBUTE, subjectService.getByID(id));
        model.addAttribute(ACTION_ATTRIBUTE, ACTION_EDIT_ATTRIBUTE_VALUE + "/" +id);
        return SUBJECT_VIEW_PATH;
    }

    @PostMapping("/edit/{id}")
    public String processEditSubject(@PathVariable long id, @ModelAttribute SubjectDTO subjectDTO) {
        subjectDTO.setId(id);
        subjectService.update(subjectDTO);
        return "redirect:/subject";
    }

    @GetMapping("/delete")
    public String processDeleteSubject(@RequestParam long id) {
        subjectService.deleteById(id);
        return "redirect:/subject";
    }
    
}