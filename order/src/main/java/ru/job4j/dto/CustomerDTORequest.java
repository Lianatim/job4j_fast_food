package ru.job4j.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CustomerDTORequest {

    @NotBlank(message = "Login must be not empty")
    private String login;
    @NotBlank(message = "Password must be not empty")
    @Min(value = 8, message = "password should not be less than 8")
    private String password;
    @NotBlank(message = "Address must be not empty")
    private String address;
    @NotBlank(message = "Phone number must be not empty")
    private int phoneNumber;
}
