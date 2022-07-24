package com.surveyMane.surveyManag.Repository;

import com.surveyMane.surveyManag.entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answers, Long> {
}
