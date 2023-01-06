package com.revature.models;

import com.revature.dtos.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public User(RegisterRequest registerRequest) {
        this.email = registerRequest.getEmail();
        this.password = registerRequest.getPassword();
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
    }
}
