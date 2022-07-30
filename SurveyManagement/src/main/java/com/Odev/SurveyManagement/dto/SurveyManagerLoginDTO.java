package com.Odev.SurveyManagement.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
@Getter
public class SurveyManagerLoginDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
