package com.example.tamingthymeleaf3.user;

import com.example.tamingthymeleaf3.user.web.CreateUserParameters;
import com.example.tamingthymeleaf3.user.web.EditUserParameters;
import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User createUser(CreateUserParameters parameters);
    // tag::getAllUsers[]
    ImmutableSet<User> getAllUsers();

    Page<User> getUsers(Pageable pageable);

    User editUser(UserId userId, EditUserParameters parameters);

    Optional<User> getUser(UserId userId);

}
