package com.surveyMane.surveyManag.Controller;

import com.surveyMane.surveyManag.Service.AnswersService;
import com.surveyMane.surveyManag.dto.AnswersDto;
import com.surveyMane.surveyManag.entities.Answers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/answers")
public class AnswerController {

    public AnswerController(AnswersService answersService) {
        AnswersService = answersService;
    }

    AnswersService AnswersService;



    @GetMapping("/{id}")
    public ResponseEntity getAnswerById(@PathVariable("id") Long id) {
        Answers byId;
        try {
            byId = AnswersService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewCourse(@RequestBody AnswersDto answersText) {
        Answers answers = AnswersService.create(answersText);
        if (answers == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Answer is not created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(answers);
    }
}
