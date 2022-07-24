package com.surveyMane.surveyManag.Repository;

import com.surveyMane.surveyManag.entities.surveyManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface surveyManagerRepo extends JpaRepository<surveyManager, Long> {
}
