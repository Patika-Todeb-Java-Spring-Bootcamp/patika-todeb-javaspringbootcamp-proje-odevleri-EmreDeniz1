package com.Odev.SurveyManagement.Mapper;

import com.Odev.SurveyManagement.Entity.Questions;
import com.Odev.SurveyManagement.dto.QuestionsDTO;

public class QuestionsMapper {

    public static QuestionsDTO toDTO (Questions questions) {
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setText(questions.getText());
        return questionsDTO;
    }

    public  static Questions toEntitiy (QuestionsDTO questionsDTO) {
        Questions questions = new Questions();
        questions.setText(questionsDTO.getText());
        return questions;
    }
}
