package com.zikan.restful_user_management.mapper;

import com.zikan.restful_user_management.dto.UserDto;
import com.zikan.restful_user_management.entity.User;

public class UserMapper {

//    convert User JPA into UserDTO
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDto;
    }
//    convert userDto into user JPA entity

    public static User mapToUser(UserDto userDto){
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return user;
    }


}
