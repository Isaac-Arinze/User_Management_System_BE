package com.zikan.restful_user_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty (message = "please input your firstName")
    private String firstName;
    @NotEmpty (message = "kindly add firstname")
    private String lastName;
    @NotEmpty (message = "Please provide a valid email address")
    @Email
    private String email;

}
