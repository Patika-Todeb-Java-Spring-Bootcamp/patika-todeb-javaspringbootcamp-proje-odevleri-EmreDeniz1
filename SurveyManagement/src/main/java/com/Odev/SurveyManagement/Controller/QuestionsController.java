package com.Odev.SurveyManagement.Controller;

import com.Odev.SurveyManagement.Entity.Questions;
import com.Odev.SurveyManagement.Entity.Survey;
import com.Odev.SurveyManagement.Repository.QuestionRepository;
import com.Odev.SurveyManagement.Service.QuestionsService;
import com.Odev.SurveyManagement.dto.QuestionsDTO;
import com.Odev.SurveyManagement.dto.SurveyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody QuestionsDTO survey) {
        Questions newQuestion = questionsService.createNewQuestion(survey);
        if(newQuestion == null)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Soru oluşturulamadı");
        return ResponseEntity.status(HttpStatus.OK).body(newQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id) {
        Questions questions;
        try {
            questions = questionsService.findById(id);
        }catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateQuestions (
            @PathVariable Long id,
            @RequestBody QuestionsDTO questionsDTO) {
        Questions updated = questionsService.updateById(id,questionsDTO);
        if(updated == null)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("günelleme yapılamadı");
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        questionsService.deleteById(id);
    }



}
