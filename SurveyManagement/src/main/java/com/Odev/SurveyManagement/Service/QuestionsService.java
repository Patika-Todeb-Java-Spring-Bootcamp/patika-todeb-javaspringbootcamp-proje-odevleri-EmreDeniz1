package com.Odev.SurveyManagement.Service;

import com.Odev.SurveyManagement.Entity.Questions;
import com.Odev.SurveyManagement.Mapper.QuestionsMapper;
import com.Odev.SurveyManagement.Repository.QuestionRepository;
import com.Odev.SurveyManagement.dto.QuestionsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    @Autowired
    QuestionRepository questionRepository;

    public Questions createNewQuestion(QuestionsDTO survey) {
        Questions questions = QuestionsMapper.toEntitiy(survey);
        return questionRepository.save(questions);
    }

    public Questions findById(Long id) {

        Optional<Questions> questions =  questionRepository.findById(id);
        return questions.orElseThrow(() -> new RuntimeException("Soru bulunamadı"));
    }

    public Questions updateById(Long id, QuestionsDTO questionsDTO) {
        Optional<Questions> check = questionRepository.findById(id);
        if(!check.isPresent())
            return null;
        Questions updatedQuestion = check.get();
        if (!StringUtils.isEmpty(questionsDTO.getText())) {
            updatedQuestion.setText(questionsDTO.getText());
        }
        return questionRepository.save(updatedQuestion);
    }

    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
