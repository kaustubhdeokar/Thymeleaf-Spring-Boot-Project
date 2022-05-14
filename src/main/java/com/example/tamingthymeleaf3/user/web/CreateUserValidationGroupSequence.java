package com.example.tamingthymeleaf3.user.web;


import com.example.tamingthymeleaf3.infrastructure.validation.ValidationGroupOne;
import com.example.tamingthymeleaf3.infrastructure.validation.ValidationGroupTwo;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface CreateUserValidationGroupSequence {
}
