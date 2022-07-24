package com.surveyMane.surveyManag.Service;

import com.surveyMane.surveyManag.Repository.surveyManagerRepo;
import com.surveyMane.surveyManag.dto.surveyManagerDto;
import com.surveyMane.surveyManag.entities.surveyManager;
import com.surveyMane.surveyManag.Mapper.surveyManagerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class surveyManagerService {

    surveyManagerRepo surveyManagerRepo;

    public surveyManagerService(surveyManagerRepo surveyManagerRepo) {
        this.surveyManagerRepo = surveyManagerRepo;
    }

    public List<surveyManager> getAllManagers() {
        List<surveyManager> allManegers = surveyManagerRepo.findAll();
        return allManegers;

    }

   public surveyManager createManager(surveyManagerDto manager) {
        surveyManager newManager = surveyManagerMapper.toEntity(manager);
        return surveyManagerRepo.save(newManager);
   }

    public surveyManager findById(Long id) {
        Optional<surveyManager> Manager = surveyManagerRepo.findById(id);
        return Manager.orElseThrow( () -> new RuntimeException("Manager not found"));
    }


    public void deleteManagerById(Long id) {
        findById(id);
        surveyManagerRepo.deleteById(id);
    }

    public surveyManager update(Long id, surveyManagerDto manager) {
        Optional<surveyManager> managerId = surveyManagerRepo.findById(id);
        if(!managerId.isPresent()){
            return null;
        }
        surveyManager updatedManager = managerId.get();
        if (!StringUtils.isEmpty(manager.getAge())) {
            updatedManager.setAge(manager.getAge());
        }
        if (!StringUtils.isEmpty(manager.getName())) {
            updatedManager.setName(manager.getName());
        }
        if (!StringUtils.isEmpty(manager.getCompany())) {
            updatedManager.setCompany(manager.getCompany());
        }
        if (!StringUtils.isEmpty(manager.getMail())) {
            updatedManager.setMail(manager.getMail());
        }
        if (!StringUtils.isEmpty(manager.getSurname())) {
            updatedManager.setSurname(manager.getSurname());
        }
        if (!StringUtils.isEmpty(manager.getUserName())) {
            updatedManager.setUserName(manager.getUserName());
        }
        return surveyManagerRepo.save(updatedManager);
    }
}
