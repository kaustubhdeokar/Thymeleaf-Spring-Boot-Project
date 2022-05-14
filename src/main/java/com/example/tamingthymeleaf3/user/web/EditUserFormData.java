package com.example.tamingthymeleaf3.user.web;

import com.example.tamingthymeleaf3.user.Email;
import com.example.tamingthymeleaf3.user.PhoneNumber;
import com.example.tamingthymeleaf3.user.User;
import com.example.tamingthymeleaf3.user.UserName;

public class EditUserFormData extends CreateUserFormData {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    private long version;

    public static EditUserFormData fromUser(User user) {
        EditUserFormData result = new EditUserFormData();
        result.setId(user.getId().asString());
        result.setVersion(user.getVersion());
        result.setFirstName(user.getUserName().getFirstName());
        result.setLastName(user.getUserName().getLastName());
        result.setGender(user.getGender());
        result.setBirthday(user.getBirthday());
        result.setEmail(user.getEmail().asString());
        result.setPhoneNumber(user.getPhoneNumber().asString());

        return result;
    }

    @Override
    public EditUserParameters toParameters() {
        return new EditUserParameters(getVersion(),new UserName(getFirstName(),getLastName()),
                getGender(),getBirthday(),new Email(getEmail()),new PhoneNumber(getPhoneNumber()));
    }
}
