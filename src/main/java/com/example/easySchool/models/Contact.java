package com.example.easySchool.models;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {

    @NotBlank(message = "Name can cannot be left Blank")
    @Size(min = 3, message = "Minimum 3 characters are required")
    private String name;

    @NotBlank(message = "Mobile Number can cannot be left Blank")
    @Pattern(regexp ="($|[0-9]{10})", message = "Minimum 10 Digits are required")
    private String mobileNum;

    @NotBlank(message = "Email can cannot be left Blank")
    @Email(message = "Please provide Valid Email Address")
    private String email;

    @NotBlank(message = "Subject can cannot be left Blank")
    @Size(min = 5, message = "Minimum 5 characters are required")
    private String subject;

    @NotBlank(message = "Message can cannot be left Blank")
    @Size(min = 3, message = "Minimum 10 characters are required")
    private String message;

}
