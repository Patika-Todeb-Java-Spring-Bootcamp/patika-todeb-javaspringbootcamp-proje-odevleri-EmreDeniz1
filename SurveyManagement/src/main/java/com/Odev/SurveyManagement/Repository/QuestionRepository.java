package com.Odev.SurveyManagement.Repository;

import com.Odev.SurveyManagement.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
}
