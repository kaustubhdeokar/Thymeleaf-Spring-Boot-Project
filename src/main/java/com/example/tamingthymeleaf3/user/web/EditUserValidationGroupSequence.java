package com.example.tamingthymeleaf3.user.web;


import com.example.tamingthymeleaf3.infrastructure.validation.ValidationGroupOne;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class})
public interface EditUserValidationGroupSequence {
}
