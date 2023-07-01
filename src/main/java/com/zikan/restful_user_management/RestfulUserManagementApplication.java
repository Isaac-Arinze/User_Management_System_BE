package com.zikan.restful_user_management;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition (
        info = @Info(
                title = "User Management System",
                description = "Spring boot REST API documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Isaac Arinze",
                        email = "isaac.arinze.dev@gmail.com",
                        url = "https://github.com/Isaac-Arinze"
                ),
                license =@License(
                        name="Apache 2.0",
                        url = "https://github.com/Isaac-Arinze"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "https://github.com/Isaac-Arinze"
        )
)
public class RestfulUserManagementApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(RestfulUserManagementApplication.class, args);
    }

}
