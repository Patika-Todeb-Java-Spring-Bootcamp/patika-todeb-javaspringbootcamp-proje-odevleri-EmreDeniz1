package com.surveyMane.surveyManag.Mapper;


import com.surveyMane.surveyManag.dto.surveyDto;
import com.surveyMane.surveyManag.entities.Survey;

public class surveyMapper {

    public static surveyDto toDto (Survey survey){
        surveyDto SurveyDto = new surveyDto();
        SurveyDto.setName(survey.getName());
        SurveyDto.setQuestionAmount(survey.getQuestionAmount());
        return SurveyDto;
    }

    public static Survey toEntity (surveyDto SurveyDto) {
        Survey survey = new Survey();
        survey.setName(SurveyDto.getName());
        survey.setQuestionAmount(SurveyDto.getQuestionAmount());
        return survey;
    }

}
