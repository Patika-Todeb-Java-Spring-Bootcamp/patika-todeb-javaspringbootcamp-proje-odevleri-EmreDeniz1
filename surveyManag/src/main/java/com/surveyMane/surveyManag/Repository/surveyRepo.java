package com.surveyMane.surveyManag.Repository;

import com.surveyMane.surveyManag.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface surveyRepo extends JpaRepository<Survey, Long> {
}
