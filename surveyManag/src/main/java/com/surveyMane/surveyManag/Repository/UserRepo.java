package com.surveyMane.surveyManag.Repository;

import com.surveyMane.surveyManag.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
