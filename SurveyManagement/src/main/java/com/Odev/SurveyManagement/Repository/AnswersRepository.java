package com.Odev.SurveyManagement.Repository;

import com.Odev.SurveyManagement.Entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
}
