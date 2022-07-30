package com.Odev.SurveyManagement.dto;

import com.Odev.SurveyManagement.Entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class SurveyManagerResponseDTO {

    private Integer id;
    private String username;
    private String email;
    private List<Role> roles;

}
