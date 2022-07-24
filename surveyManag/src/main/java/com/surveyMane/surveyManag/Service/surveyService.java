package com.surveyMane.surveyManag.Service;

import com.surveyMane.surveyManag.Repository.surveyRepo;
import com.surveyMane.surveyManag.dto.surveyDto;
import com.surveyMane.surveyManag.entities.Survey;
import com.surveyMane.surveyManag.Mapper.surveyMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class surveyService {

    surveyRepo surveyRepo;

    surveyService(surveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public List<Survey> getAllCourses() {
        List<Survey> allCourses = surveyRepo.findAll();
        return allCourses;
    }

    public Survey getById(Long id) {
        Optional<Survey> survey = surveyRepo.findById(id);
        return survey.orElseThrow( () -> new RuntimeException("Survey not Found"));

    }

    public Survey create(surveyDto survey) {
        Survey newSurvey = surveyMapper.toEntity(survey);
        return surveyRepo.save(newSurvey);
    }

    public void delete(Long id) {
        surveyRepo.deleteById(id);
    }


    public Survey update(Long id, surveyDto survey) {
        Optional<Survey> surveyUpdate = surveyRepo.findById(id);
        if (!surveyUpdate.isPresent())
            return null;
        Survey updatedSurvey = surveyUpdate.get();
        if (!StringUtils.isEmpty(survey.getName())) {
            updatedSurvey.setName(survey.getName());
        }
        if (!StringUtils.isEmpty(survey.getQuestionAmount())) {
            updatedSurvey.setQuestionAmount(survey.getQuestionAmount());
        }

        return surveyRepo.save(updatedSurvey);
    }
}
