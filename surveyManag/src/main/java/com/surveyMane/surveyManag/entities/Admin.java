package com.surveyMane.surveyManag.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Admin {

    @Id
    private Long id;


    private String name;
    private String surname;
    private String mail;
    private Integer age;
    private List<Survey> surveys;
    private String userName;
    private String password;
}
