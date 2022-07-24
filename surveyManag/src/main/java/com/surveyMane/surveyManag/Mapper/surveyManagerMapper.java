package com.surveyMane.surveyManag.Mapper;

import com.surveyMane.surveyManag.dto.surveyManagerDto;
import com.surveyMane.surveyManag.entities.surveyManager;

public class surveyManagerMapper {

    public static surveyManagerDto toDTO(surveyManager manager) {
        surveyManagerDto ManagerDto = new surveyManagerDto();
        ManagerDto.setName(manager.getName());
        ManagerDto.setSurname(manager.getSurname());
        ManagerDto.setCompany(manager.getCompany());
        ManagerDto.setMail(manager.getMail());
        ManagerDto.setAge(manager.getAge());
        ManagerDto.setUserName(manager.getUserName());
        ManagerDto.setPassword(manager.getPassword());;
        return ManagerDto;
    }

    public static surveyManager toEntity(surveyManagerDto sManager) {
        surveyManager Manager = new surveyManager();
        Manager.setName(sManager.getName());
        Manager.setSurname(sManager.getSurname());
        Manager.setCompany(sManager.getCompany());
        Manager.setMail(sManager.getMail());
        Manager.setAge(sManager.getAge());
        Manager.setUserName(sManager.getUserName());
        Manager.setPassword(sManager.getPassword());;
        return Manager;
    }
}
