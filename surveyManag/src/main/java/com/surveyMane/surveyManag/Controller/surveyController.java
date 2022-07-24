package com.surveyMane.surveyManag.Controller;

import com.surveyMane.surveyManag.Service.surveyService;
import com.surveyMane.surveyManag.dto.surveyDto;
import com.surveyMane.surveyManag.entities.Survey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/survey")
public class surveyController {

    surveyService surveyService;

    surveyController(surveyService surveyService){
        this.surveyService = surveyService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllCourses() {
        List<Survey> allCourses = surveyService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSurveyById(@PathVariable("id") Long id) {
        Survey byId;
        try {
            byId = surveyService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewSurvey(@RequestBody surveyDto survey) {
        Survey newSurvey = surveyService.create(survey);
        if (newSurvey == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Course could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newSurvey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSurvey(@RequestParam(name = "id") Long id) {
        try {
            surveyService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Survey deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSurvey(
            @PathVariable Long id,
            @RequestBody surveyDto survey) {
        Survey update = surveyService.update(id, survey);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Servey is not updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
