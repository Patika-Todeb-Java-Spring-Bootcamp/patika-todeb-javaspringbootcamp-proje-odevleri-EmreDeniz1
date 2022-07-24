package com.surveyMane.surveyManag.Service;

import com.surveyMane.surveyManag.Repository.UserRepo;
import com.surveyMane.surveyManag.dto.UserDto;
import com.surveyMane.surveyManag.entities.User;
import com.surveyMane.surveyManag.Mapper.userMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    private UserRepo userRepo;

    public userService(UserRepo UserRepo){

        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    public void deleteUserById(Long userId) {
         userRepo.deleteById(userId);
    }

    public User makeNewUser(UserDto newuser) {
        User user = userMapper.toEntity(newuser);
        return  userRepo.save(user);
    }

    public User findUser(Long userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateById(Long id, UserDto user) {
        Optional<User> userUpdate = userRepo.findById(id);
        if (!userUpdate.isPresent())
            return null;
        User updatedUser = userUpdate.get();
        if (!StringUtils.isEmpty(user.getAge())) {
            updatedUser.setAge(user.getAge());
        }
        if(!StringUtils.isEmpty(user.getName())) {
            updatedUser.setName(user.getName());
        }
        if(!StringUtils.isEmpty(user.getGender())) {
            updatedUser.setGender(user.getGender());
        }
        return userRepo.save(updatedUser);
    }

    public void delete(Long id) {
       userRepo.deleteById(id);
    }
}
