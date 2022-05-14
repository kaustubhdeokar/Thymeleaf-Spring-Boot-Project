package com.example.tamingthymeleaf3.user.web;

import com.example.tamingthymeleaf3.user.Email;
import com.example.tamingthymeleaf3.user.Gender;
import com.example.tamingthymeleaf3.user.PhoneNumber;
import com.example.tamingthymeleaf3.user.UserName;

import java.time.LocalDate;

public class CreateUserParameters {
    private final UserName userName;
    private final Gender gender;
    private final LocalDate birthday;
    private final Email email;
    private final PhoneNumber phoneNumber;

    public CreateUserParameters(UserName userName,
                                Gender gender,
                                LocalDate birthday,
                                Email email,
                                PhoneNumber phoneNumber) {
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserName getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

}