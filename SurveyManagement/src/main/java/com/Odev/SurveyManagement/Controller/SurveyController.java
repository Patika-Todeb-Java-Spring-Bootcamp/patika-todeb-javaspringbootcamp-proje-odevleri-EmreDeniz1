package com.Odev.SurveyManagement.Controller;

import com.Odev.SurveyManagement.Entity.Survey;
import com.Odev.SurveyManagement.Service.SurveyService;
import com.Odev.SurveyManagement.dto.SurveyDTO;
import com.Odev.SurveyManagement.dto.UserDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    SurveyService surveyService;

    SurveyController(SurveyService surveyService) {

        this.surveyService = surveyService;
    }

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody SurveyDTO survey) {
        Survey newSurvey = surveyService.createNewSurvey(survey);
        return ResponseEntity.status(HttpStatus.OK).body(newSurvey);
    }

    @GetMapping("/all")
    public ResponseEntity getAll () {
        List<Survey> surveys = surveyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(surveys);
    }

    @GetMapping("/{id}")
    public ResponseEntity getFromId (@PathVariable Long id) {
        Survey survey;
        try{
            survey = surveyService.fromId(id);
        }catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(survey);
    }

    @DeleteMapping("/{id}")
    public void deleteFromId (@PathVariable Long id) {
        surveyService.delete(id);
        ResponseEntity.status(HttpStatus.OK).body("Sruvey deleted");
    }

    @PutMapping("/{name}")
    public ResponseEntity updateSurvey (
            @PathVariable String name,
            @RequestBody SurveyDTO survey) {
        Survey updatedSurvey = surveyService.updateSurvey(name, survey);
        if(updatedSurvey == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.OK).body(updatedSurvey);
    }
}
