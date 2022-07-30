package com.Odev.SurveyManagement.Mapper;


import com.Odev.SurveyManagement.Entity.User;
import com.Odev.SurveyManagement.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(user.getAge());
        userDTO.setGender(user.getGender());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public static User toEntity (UserDTO userDTO) {
      User user = new User();
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
