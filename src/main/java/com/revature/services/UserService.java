package com.revature.services;

import com.revature.dtos.RequestUser;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(RequestUser requestUser) {
        Optional<User> user = userRepository.findByEmail(requestUser.getEmail());

        if (user.isEmpty()) {
            return userRepository.save(new User(requestUser));
        }
        return user.get();
    }
}
