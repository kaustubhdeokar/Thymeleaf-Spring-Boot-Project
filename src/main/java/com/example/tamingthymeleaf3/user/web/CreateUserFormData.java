package com.example.tamingthymeleaf3.user.web;

import com.example.tamingthymeleaf3.user.Gender;
import com.example.tamingthymeleaf3.user.PhoneNumber;
import com.example.tamingthymeleaf3.user.UserName;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CreateUserFormData {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Gender gender;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @NotBlank
    @Pattern(regexp = "[0-9.\\-() x/+]+")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CreateUserParameters toParameters() {
        return new CreateUserParameters(new UserName(firstName, lastName),
                gender,
                birthday,
                new com.example.tamingthymeleaf3.user.Email(email),
                new PhoneNumber(phoneNumber));
    }

}
