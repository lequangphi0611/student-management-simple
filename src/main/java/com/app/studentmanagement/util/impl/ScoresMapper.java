package com.app.studentmanagement.util.impl;

import com.app.studentmanagement.dto.ScoresDTO;
import com.app.studentmanagement.entity.Scores;
import com.app.studentmanagement.util.Mapper;

/**
 * ScoresMapper
 */
public class ScoresMapper implements Mapper<Scores, ScoresDTO> {

    private final SubjectMapper subjectMapper = new SubjectMapper();
    private final StudentMapper studentMapper = new StudentMapper();

    @Override
    public ScoresDTO parseDTO(Scores entity) {
        ScoresDTO scoresDTO = new ScoresDTO();
        scoresDTO.setId(entity.getId());
        scoresDTO.setValue(entity.getValue());
        scoresDTO.setStudentDTO(studentMapper.parseDTO(entity.getStudent()));
        scoresDTO.setSubjectDTO(subjectMapper.parseDTO(entity.getSubject()));
        return scoresDTO;
    }

    @Override
    public Scores parseEntity(ScoresDTO dto) {
        Scores scores = new Scores();
        scores.setValue(dto.getValue());
        scores.setStudent(studentMapper.parseEntity(dto.getStudentDTO()));
        scores.setSubject(subjectMapper.parseEntity(dto.getSubjectDTO()));
        return scores;
    }

}