package com.revature.services;

import com.revature.dtos.RequestUser;
import com.revature.exceptions.UserAlreadyExistsException;
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

    public User saveUser(RequestUser requestUser) {
        User updatedUser = new User(requestUser);

        User oldUser = userRepository.getReferenceById(requestUser.getId());

        if (
                !updatedUser.getEmail().equals(oldUser.getEmail()) &&
                        !updatedUser.getUsername().equals(oldUser.getUsername()) &&
                        !userRepository.existsByEmailOrUsername(updatedUser.getEmail(), updatedUser.getUsername())
        ) {
            return userRepository.save(updatedUser);
        } else if (
                !updatedUser.getEmail().equals(oldUser.getEmail()) &&
                        !userRepository.existsByEmail(updatedUser.getEmail())
        ) {
            return userRepository.save(updatedUser);
        } else if (
                !updatedUser.getUsername().equals(oldUser.getUsername()) &&
                        !userRepository.existsByUsername(updatedUser.getUsername())
        ) {
            return userRepository.save(updatedUser);
        }

        throw new UserAlreadyExistsException();
    }
}
