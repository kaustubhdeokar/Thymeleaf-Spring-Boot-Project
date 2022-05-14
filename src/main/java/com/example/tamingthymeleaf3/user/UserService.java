package com.example.tamingthymeleaf3.user;

import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User createUser(CreateUserParameters parameters);
    // tag::getAllUsers[]
    ImmutableSet<User> getAllUsers();

    Page<User> getUsers(Pageable pageable);

}
