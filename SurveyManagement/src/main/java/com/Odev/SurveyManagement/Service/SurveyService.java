package com.Odev.SurveyManagement.Service;

import com.Odev.SurveyManagement.Entity.Survey;
import com.Odev.SurveyManagement.Mapper.SurveyMapper;
import com.Odev.SurveyManagement.Repository.SurveyRepository;
import com.Odev.SurveyManagement.dto.SurveyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;


    public Survey createNewSurvey(SurveyDTO surveyDTO) {
        Survey newSurvey = SurveyMapper.toEntitiy(surveyDTO);
        return surveyRepository.save((newSurvey));
    }


    public List<Survey> findAll() {
        List<Survey> surveys = surveyRepository.findAll();
        return surveys;
    }

    public Survey fromId(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElseThrow(() -> new RuntimeException("survey not found"));
    }

    public void delete(Long id) {
        surveyRepository.deleteById(id);
    }


    public Survey updateSurvey(String name, SurveyDTO survey) {
       Optional<Survey> SurveyFromName = surveyRepository.findSurveyByName(name);
        if(!SurveyFromName.isPresent())
            return null;
        Survey updatedSurvey = SurveyFromName.get();
        if (!StringUtils.isEmpty(survey.getName())) {
            updatedSurvey.setName(survey.getName());
        }
        if (!StringUtils.isEmpty(survey.getCreator())) {
            updatedSurvey.setCreator(survey.getCreator());
        }
        return surveyRepository.save(updatedSurvey);
    }
}
