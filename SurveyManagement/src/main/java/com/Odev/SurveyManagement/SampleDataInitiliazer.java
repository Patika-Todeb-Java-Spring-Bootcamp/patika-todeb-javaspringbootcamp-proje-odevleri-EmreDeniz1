package com.Odev.SurveyManagement;

import com.Odev.SurveyManagement.Entity.SurveyManager;
import com.Odev.SurveyManagement.Repository.SurveyManagerRepository;
import com.Odev.SurveyManagement.Service.SurveyManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {

    private final SurveyManagerRepository surveyManagerRepository;
    private final SurveyManagerService surveyManagerService;


    @Override
    public void run(ApplicationArguments args) {


        // Creating a sample Admin USER
        SurveyManager adminUser = new SurveyManager("admin-user", "adminuser@mail.com", "pass1234");
        if (!surveyManagerRepository.existsByUsername(adminUser.getUsername())) {
            surveyManagerService.signup(adminUser, true);
        }

        // Creating a sample USER
        SurveyManager sampleUser = new SurveyManager("sample-user", "sampleuser@mail.com", "pass1234");
        if (!surveyManagerRepository.existsByUsername(sampleUser.getUsername())) {
            surveyManagerService.signup(sampleUser, false);
        }

    }

}
