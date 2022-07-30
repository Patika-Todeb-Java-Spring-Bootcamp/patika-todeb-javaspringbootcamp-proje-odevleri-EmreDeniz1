package com.Odev.SurveyManagement.Repository;

import com.Odev.SurveyManagement.Entity.SurveyManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SurveyManagerRepository extends JpaRepository<SurveyManager, Integer> {

    boolean existsByUsername(String username);

    SurveyManager findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
