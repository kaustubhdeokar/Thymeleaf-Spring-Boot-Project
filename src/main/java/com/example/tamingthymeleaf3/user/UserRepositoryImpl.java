package com.example.tamingthymeleaf3.user;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final UniqueIdGenerator<UUID> generator;

    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public UserId nextId() {
        return new UserId(generator.getNextUniqueId());
    }
}