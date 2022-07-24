package com.surveyMane.surveyManag.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="Questions")
@Data
public class Questions {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="survey_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Survey survey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

}
