package com.surveyMane.surveyManag.Controller;

import com.surveyMane.surveyManag.Service.surveyManagerService;
import com.surveyMane.surveyManag.dto.surveyManagerDto;
import com.surveyMane.surveyManag.entities.surveyManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveyManager")
public class surveyManagerController {

    private surveyManagerService surveyManagerService;

    public surveyManagerController(surveyManagerService surveyManagerService) {
        this.surveyManagerService = surveyManagerService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllManagers() {
        List<surveyManager> getAllManagers = surveyManagerService.getAllManagers();
        return ResponseEntity.ok(getAllManagers);
    }

    @PostMapping("/create")
    public ResponseEntity createNewManager(@RequestBody surveyManagerDto manager) {
        surveyManager newManager = surveyManagerService.createManager(manager);
        if (newManager == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Manager could not be created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newManager);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        surveyManager manager;
        try {
            manager = surveyManagerService.findById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(manager);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteManager(@PathVariable("id") Long id) {
        try {
            surveyManagerService.deleteManagerById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Manager Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCourse(
            @PathVariable Long id,
            @RequestBody surveyManagerDto manager) {
        surveyManager update = surveyManagerService.update(id, manager);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Course could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }


}