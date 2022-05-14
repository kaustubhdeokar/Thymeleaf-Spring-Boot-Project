package com.example.tamingthymeleaf3.user;

import org.springframework.stereotype.Component;

@Component
public interface UniqueIdGenerator<T> {


    public T getNextUniqueId();
}
