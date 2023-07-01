package com.zikan.restful_user_management.service;

import com.zikan.restful_user_management.dto.UserDto;
import com.zikan.restful_user_management.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser (UserDto user);

    void deleteUser (Long userId);

}
