package com.Odev.SurveyManagement.Service;

import com.Odev.SurveyManagement.Entity.User;
import com.Odev.SurveyManagement.Mapper.UserMapper;
import com.Odev.SurveyManagement.Repository.UserRepository;
import com.Odev.SurveyManagement.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;



    public User createNewUser(UserDTO newUser) {
        User user = UserMapper.toEntity(newUser);
        return userRepository.save(user);
    }

    public List<User> All() {
        List<User> user = userRepository.findAll();
        return user;
    }

    public User fromId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found"));

    }

    public void deleteId(Long id) {
        userRepository.deleteById(id);
    }
}
