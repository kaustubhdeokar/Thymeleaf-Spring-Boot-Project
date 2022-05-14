package com.example.tamingthymeleaf3.user;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity(name = "tt_user")
public class User extends AbstractVersionedEntity<UserId> {

    @NotNull
    private UserName userName; //<.>
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender; //<.>
    @NotNull
    private LocalDate birthday; //<.>
    @NotNull
    private Email email; //<.>
    @NotNull
    private PhoneNumber phoneNumber; //<.>

    protected User() {
    }

    public User(UserId id,
                UserName userName,
                Gender gender,
                LocalDate birthday,
                Email email,
                PhoneNumber phoneNumber) {
        super(id);
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

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}