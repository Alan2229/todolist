package org.example.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todo.model.User;
import org.example.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }
}
