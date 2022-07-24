package com.surveyMane.surveyManag.entities;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"user\"")
@Data
public class User {

    @Id
    private Long id;

    private String name;
    private String gender;
    private Integer age;

    @ManyToMany
    private List<Survey> filledSurveys;


}
