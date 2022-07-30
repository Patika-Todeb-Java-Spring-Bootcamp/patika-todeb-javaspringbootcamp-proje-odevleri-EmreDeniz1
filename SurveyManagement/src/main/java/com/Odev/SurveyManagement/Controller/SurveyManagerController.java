package com.Odev.SurveyManagement.Controller;

import com.Odev.SurveyManagement.Entity.SurveyManager;
import com.Odev.SurveyManagement.Repository.SurveyManagerRepository;
import com.Odev.SurveyManagement.Service.SurveyManagerService;
import com.Odev.SurveyManagement.dto.SurveyManagerDataDTO;
import com.Odev.SurveyManagement.dto.SurveyManagerLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/surveyManager")
public class SurveyManagerController {

    @Autowired
    SurveyManagerService surveyManagerService;

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_CLIENT')")
    @GetMapping
    public List<SurveyManager> getAllUsers() {
        return surveyManagerService.getAll();
    }

    @PostMapping("/signin")
    public String login(@Valid @RequestBody SurveyManagerLoginDTO ManagerLoginDTO) {
        return surveyManagerService.signin(ManagerLoginDTO.getUsername(), ManagerLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SurveyManagerDataDTO userDataDTO) {
        SurveyManager surveyManager = new SurveyManager();
        surveyManager.setUsername(userDataDTO.getUsername());
        surveyManager.setEmail(userDataDTO.getEmail());
        surveyManager.setPassword(userDataDTO.getPassword());
        return surveyManagerService.signup(surveyManager, false);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {
        surveyManagerService.delete(username);
        return username + " was deleted successfully";
    }

    @GetMapping(value = "/search/{username}")
    public SurveyManager searchByUserName(@PathVariable String username) {

        return surveyManagerService.search(username);
    }
}
