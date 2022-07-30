package com.Odev.SurveyManagement.Mapper;


import com.Odev.SurveyManagement.Entity.Survey;
import com.Odev.SurveyManagement.dto.SurveyDTO;

public class SurveyMapper {

    public static SurveyDTO toDTO (Survey survey) {
        SurveyDTO surveyDTO = new SurveyDTO();
        surveyDTO.setCreator(survey.getCreator());
        surveyDTO.setName(survey.getName());
        return surveyDTO;
    }

    public static Survey toEntitiy (SurveyDTO surveyDTO) {
        Survey survey = new Survey();
        survey.setCreator(surveyDTO.getCreator());
        survey.setName(surveyDTO.getName());
        return survey;
    }
}
