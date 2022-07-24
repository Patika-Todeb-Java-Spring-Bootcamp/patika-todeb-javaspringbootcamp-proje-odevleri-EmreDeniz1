package com.surveyMane.surveyManag.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="surveyManager")
@Data
public class surveyManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String company;
    private String mail;
    private Integer age;
    //private List<Survey> createdsurveys;
    private String userName;
    private String password;
}
