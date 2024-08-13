package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class User {
@Id
@GeneratedValue
    private int id;
    private String username;
    private String password;
    private Date createdAt;

}
