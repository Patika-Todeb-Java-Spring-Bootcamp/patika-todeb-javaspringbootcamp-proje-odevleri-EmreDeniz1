package com.surveyMane.surveyManag.Mapper;

import com.surveyMane.surveyManag.dto.AnswersDto;
import com.surveyMane.surveyManag.dto.surveyDto;
import com.surveyMane.surveyManag.entities.Answers;
import com.surveyMane.surveyManag.entities.Survey;

public class AnswerMapper {

    public static AnswersDto toDto (Answers answers){
        AnswersDto answersDto = new AnswersDto();
        answersDto.setText(answers.getText());
        return answersDto;
    }

    public static Answers toEntity (AnswersDto answersDto) {
        Answers answers = new Answers();
        answers.setText(answersDto.getText());
        return answers;
    }
}
