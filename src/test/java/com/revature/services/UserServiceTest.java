package com.revature.services;

import com.revature.dtos.RequestUser;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService sut;

    @MockBean
    UserRepository mockUserRepository;

    @Test
    void test_getUser_returnsUser_givenUserAlreadyExists() {
        String username = "crazyUsername";
        String email = "validEmail@email.com";
        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(username);
        requestUser.setEmail(email);
        User user = new User(2, email, username);

        when(mockUserRepository.findByEmail(requestUser.getEmail())).thenReturn(Optional.of(user));

        User actual = sut.getUser(requestUser);

        verify(mockUserRepository, times(1)).findByEmail(requestUser.getEmail());
        Assertions.assertEquals(user, actual);
    }

    @Test
    void test_getUser_returnsUser_givenUserDoesNotExists() {
        String username = "crazyUsername";
        String email = "validEmail@email.com";
        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(username);
        requestUser.setEmail(email);
        User user = new User(requestUser);

        when(mockUserRepository.findByEmail(requestUser.getEmail())).thenReturn(Optional.empty());
        when(mockUserRepository.save(user)).thenReturn(user);

        User actual = sut.getUser(requestUser);

        verify(mockUserRepository, times(1)).findByEmail(requestUser.getEmail());
        verify(mockUserRepository, times(1)).save(user);
        Assertions.assertEquals(user.getEmail(), actual.getEmail());
        Assertions.assertEquals(user.getUsername(), actual.getUsername());
    }

    @Test
    void saveUser1() {
        RequestUser requestUser = new RequestUser(1,"Joe","email@email.com");
        User user = new User(requestUser);
        User testUser = new User(1,"testemail@email2.com","Joeby");
        when(mockUserRepository.getReferenceById(user.getId())).thenReturn(testUser);
        when(mockUserRepository.existsByEmailOrUsername(user.getEmail(),user.getUsername())).thenReturn(false);
        when(mockUserRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(mockUserRepository.existsByUsername(user.getUsername())).thenReturn(false);
        when(mockUserRepository.save(user)).thenReturn(user);
        sut.saveUser(requestUser);
        verify(mockUserRepository,times(1)).save(user);
    }
    @Test
    void saveUser2() {
        RequestUser requestUser = new RequestUser(1,"Joe","email@email.com");
        User user = new User(requestUser);
        User testUser = new User(1,"testemail@email2.com","Joe");
        when(mockUserRepository.getReferenceById(user.getId())).thenReturn(testUser);
        when(mockUserRepository.existsByEmailOrUsername(user.getEmail(),user.getUsername())).thenReturn(false);
        when(mockUserRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(mockUserRepository.existsByUsername(user.getUsername())).thenReturn(false);
        when(mockUserRepository.save(user)).thenReturn(user);
        sut.saveUser(requestUser);
        verify(mockUserRepository,times(1)).save(user);
    }
    @Test
    void saveUser3() {
        RequestUser requestUser = new RequestUser(1,"Joe","email@email.com");
        User user = new User(requestUser);
        User testUser = new User(1,"email@email.com","Joeby");
        when(mockUserRepository.getReferenceById(user.getId())).thenReturn(testUser);
        when(mockUserRepository.existsByEmailOrUsername(user.getEmail(),user.getUsername())).thenReturn(false);
        when(mockUserRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(mockUserRepository.existsByUsername(user.getUsername())).thenReturn(false);
        when(mockUserRepository.save(user)).thenReturn(user);
        sut.saveUser(requestUser);
        verify(mockUserRepository,times(1)).save(user);
    }
    @Test
    void saveUser4() {
        RequestUser requestUser = new RequestUser(1,"Joe","email@email.com");
        User user = new User(requestUser);
        User testUser = new User(1,"email@email.com","Joe");
        when(mockUserRepository.getReferenceById(user.getId())).thenReturn(testUser);
        when(mockUserRepository.existsByEmailOrUsername(user.getEmail(),user.getUsername())).thenReturn(false);
        when(mockUserRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(mockUserRepository.existsByUsername(user.getUsername())).thenReturn(false);
        when(mockUserRepository.save(user)).thenReturn(user);
        Assertions.assertThrows(UserAlreadyExistsException.class, ()->{sut.saveUser(requestUser);});

    }
}