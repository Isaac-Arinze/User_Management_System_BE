package com.zikan.restful_user_management.controller;

import com.zikan.restful_user_management.dto.UserDto;
import com.zikan.restful_user_management.entity.User;
import com.zikan.restful_user_management.exception.ErrorDetails;
import com.zikan.restful_user_management.exception.ResourceNotFoundException;
import com.zikan.restful_user_management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Delete User, Delete All Users"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user details in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By Id REST API",
            description = "Get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success!"
    )

//    Build Get REST API by ID
    @GetMapping("{id}")
    public ResponseEntity <UserDto> getUserById (@PathVariable ("id") Long userId){

        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Users REST API",
            description = " Get All User from the  database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Successful"
    )
    @GetMapping
    public ResponseEntity <List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 201 success"
    )
//    build update user REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser (@PathVariable ("id") Long userId, @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

//    To handle specific error tied to the controller only, we simply implement the ff login
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),

//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//
//    }

}
