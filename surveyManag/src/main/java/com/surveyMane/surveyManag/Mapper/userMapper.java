package com.surveyMane.surveyManag.Mapper;

import com.surveyMane.surveyManag.dto.UserDto;
import com.surveyMane.surveyManag.entities.User;

public class userMapper {

    public static UserDto toDto (User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        return userDto;
    }

    public static User toEntity (UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setName(userDto.getName());
        return user;
    }
}
