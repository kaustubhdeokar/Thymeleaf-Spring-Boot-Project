package com.example.tamingthymeleaf3.user;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UniqueIdGeneratorImpl implements UniqueIdGenerator<UUID> {
    @Override
    public UUID getNextUniqueId() {
        return UUID.randomUUID();
    }
}
