package com.ss.week2.jdbcakbar.controller;

import com.ss.week2.jdbcakbar.model.User;
import com.ss.week2.jdbcakbar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        try {
            User user = userService.getUser(userId);
            if(user == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (SQLException | ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser;
        try {
            int userId = userService.createUser(user);
            createdUser = userService.getUser(userId);

        } catch (SQLException | ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
