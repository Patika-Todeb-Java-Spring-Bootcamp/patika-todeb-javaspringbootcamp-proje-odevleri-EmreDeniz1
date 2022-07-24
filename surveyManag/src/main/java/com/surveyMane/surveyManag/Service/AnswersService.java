package com.surveyMane.surveyManag.Service;

import com.surveyMane.surveyManag.Mapper.AnswerMapper;
import com.surveyMane.surveyManag.Repository.AnswerRepo;
import com.surveyMane.surveyManag.dto.AnswersDto;
import com.surveyMane.surveyManag.entities.Answers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswersService {

   AnswerRepo AnswerRepo;

    public AnswersService(AnswerRepo answerRepo) {
        AnswerRepo = answerRepo;
    }

    public Answers getById(Long id) {
        Optional<Answers> byId = AnswerRepo.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Course not found!"));
    }

    public Answers create(AnswersDto answersText) {
        Answers answers = AnswerMapper.toEntity(answersText);
        return AnswerRepo.save(answers);
    }
}
