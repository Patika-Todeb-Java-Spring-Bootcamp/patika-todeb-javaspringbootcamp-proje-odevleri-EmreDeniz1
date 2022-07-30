package com.Odev.SurveyManagement.Service;

import com.Odev.SurveyManagement.Entity.Answers;
import com.Odev.SurveyManagement.Mapper.AnswersMapper;
import com.Odev.SurveyManagement.Repository.AnswersRepository;
import com.Odev.SurveyManagement.dto.AnswersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswersService {

    @Autowired
    AnswersRepository answersRepository;

    public Answers createNewAnswer(AnswersDTO answersDTO) {
        Answers answers = AnswersMapper.toEntity(answersDTO);
        return answersRepository.save(answers);
    }

    public List<Answers> getAll() {
        List<Answers> answers = answersRepository.findAll();
        return answers;
    }

    public Answers getById(Long id) {
        Optional<Answers> answers = answersRepository.findById(id);
        return answers.orElseThrow(() -> new RuntimeException ("Cevap Bulunamadı"));
    }

    public void deleteIt(Long id) {
        answersRepository.deleteById(id);
    }
}
