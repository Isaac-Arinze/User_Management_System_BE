package com.zikan.restful_user_management.service.impl;

import com.zikan.restful_user_management.dto.UserDto;
import com.zikan.restful_user_management.entity.User;
import com.zikan.restful_user_management.exception.EmailAlreadyExistsException;
import com.zikan.restful_user_management.exception.ResourceNotFoundException;
import com.zikan.restful_user_management.mapper.UserMapper;
import com.zikan.restful_user_management.repository.UserRepository;
import com.zikan.restful_user_management.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {

//        convert UserDto into usER JPA Entity
//        User user = UserMapper.mapToUser(userDto);
//      We need to check if there is an email already existing in DB using the ff logic

        Optional <User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already exists for user");
        }

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
//        convert user JPA entity to userDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }
    @Override
    public UserDto getUserById(Long userId) {
       User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
//       User user = optionalUser.get();
//       return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

        return users.stream().map((user)-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).orElseThrow(()->new ResourceNotFoundException("existingUs", "id", user.getId()));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

//        return UserMapper.mapToUserDto(updatedUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}
