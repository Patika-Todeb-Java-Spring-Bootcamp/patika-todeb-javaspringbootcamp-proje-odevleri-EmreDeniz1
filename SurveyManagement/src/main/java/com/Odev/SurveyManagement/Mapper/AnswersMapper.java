package com.Odev.SurveyManagement.Mapper;

import com.Odev.SurveyManagement.Entity.Answers;
import com.Odev.SurveyManagement.dto.AnswersDTO;

public class AnswersMapper {

    public static AnswersDTO toDTO (Answers answers) {
        AnswersDTO answersDTO = new AnswersDTO();
        answersDTO.setText(answers.getText());
        return answersDTO;
    }

    public static Answers toEntity (AnswersDTO answersDTO) {
        Answers answers = new Answers();
        answers.setText(answersDTO.getText());
        return answers;
    }
}
