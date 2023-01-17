package com.revature.models;

import com.revature.dtos.RequestUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;

    public User(RequestUser requestUser) {
        this.email = requestUser.getEmail();
        this.username = requestUser.getUsername();
        this.id = requestUser.getId();
    }
}
