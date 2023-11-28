package com.s3valkov.unilib.dto.binding.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserServiceModel {

    private Long id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5,max = 20, message = "Username length must be between 5 and 20 characters")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 5,max = 20, message = "Password length must be minimum 5 characters")
    private String password;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Email(message = "Please enter a valid email address")
    private String email;

    private AddressServiceModel address;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public AddressServiceModel getAddress() {
        return address;
    }
}
