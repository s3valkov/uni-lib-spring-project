package com.s3valkov.unilib.dto.binding.auth;

import com.s3valkov.unilib.validation.PasswordValidator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@PasswordValidator(pass = "password",
        confPass = "confirmPassword",
        message = "The passwords don't match")
public class UserRegisterBindingModel {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5,max = 20, message = "Username length must be between 5 and 20 characters")
    private String username;

    @NotBlank
    @Size(min = 5,max = 20, message = "Password length must be minimum 5 characters")
    private String password;

    @NotBlank
    @Size(min = 5,max = 20, message = "Password length must be minimum 5 characters")
    private String confirmPassword;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Email(message = "Please enter a valid email address")
    private String email;

    private AddressServiceModel address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }
}
