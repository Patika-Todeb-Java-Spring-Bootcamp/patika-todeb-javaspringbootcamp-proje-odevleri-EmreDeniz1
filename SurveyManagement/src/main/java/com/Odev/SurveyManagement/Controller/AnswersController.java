package com.Odev.SurveyManagement.Controller;

import com.Odev.SurveyManagement.Entity.Answers;
import com.Odev.SurveyManagement.Service.AnswersService;
import com.Odev.SurveyManagement.dto.AnswersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswersController {

    @Autowired
    AnswersService answersService;

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody AnswersDTO answersDTO) {
        Answers answers = answersService.createNewAnswer(answersDTO);
        if(answers == null)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("cevap yaratılamadı");
        return ResponseEntity.status(HttpStatus.OK).body(answers);
    }

    @GetMapping("/all")
    public ResponseEntity getAll () {
        List<Answers> answers = answersService.getAll();
        if(answers.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zero result");
        return ResponseEntity.status(HttpStatus.OK).body(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Long id) {
        Answers answers;
        try {
            answers = answersService.getById(id);
        }catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(answers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBy  (@PathVariable Long id) {
        try {
            answersService.deleteIt(id);
        }catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Answer deleted");
    }

}
