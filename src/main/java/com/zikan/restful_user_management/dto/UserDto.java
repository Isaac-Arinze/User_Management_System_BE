package com.zikan.restful_user_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "User First Name"
    )

    @NotEmpty (message = "please input your firstName")
    private String firstName;

    @Schema(
            description = "User last Name"
    )
    @NotEmpty (message = "kindly add firstname")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    @NotEmpty (message = "Please provide a valid email address")
    @Email
    private String email;

}
