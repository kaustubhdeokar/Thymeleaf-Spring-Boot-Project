package com.example.tamingthymeleaf3.user;

import com.example.tamingthymeleaf3.user.web.CreateUserParameters;
import com.example.tamingthymeleaf3.user.web.EditUserParameters;
import com.example.tamingthymeleaf3.user.web.UserNotFoundException;
import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(CreateUserParameters parameters) {
        UserId userId = repository.nextId(); //<.>
        User user = new User(userId,
                parameters.getUserName(),
                parameters.getGender(),
                parameters.getBirthday(),
                parameters.getEmail(),
                parameters.getPhoneNumber()); //<.>
        return repository.save(user); //<.>
    }

    @Override
    public ImmutableSet<User> getAllUsers() {
        return ImmutableSet.copyOf(repository.findAll());
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User editUser(UserId userId, EditUserParameters parameters) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        if (parameters.getVersion() != user.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(User.class, user.getId().asString());
        }

        parameters.update(user);
        return user;
    }

    public Optional<User> getUser(UserId userId) {
        return repository.findById(userId);
    }

    @Override
    public void deleteUser(UserId userId) {
        repository.deleteById(userId);
    }
}
