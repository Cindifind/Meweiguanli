package com.example.demo.controller;

import com.example.demo.exception.UsernameExistsException;
import com.example.demo.model.AddUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/AddUsers")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // 注册用户
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody AddUser user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<>("用户添加成功", HttpStatus.CREATED);
        } catch (UsernameExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("服务器错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("服务器错误", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
