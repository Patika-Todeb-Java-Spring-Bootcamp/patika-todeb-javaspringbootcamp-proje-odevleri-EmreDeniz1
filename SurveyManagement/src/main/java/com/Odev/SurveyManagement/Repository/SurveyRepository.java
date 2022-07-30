package com.Odev.SurveyManagement.Repository;

import com.Odev.SurveyManagement.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Optional<Survey> findSurveyByName(String name);
}
