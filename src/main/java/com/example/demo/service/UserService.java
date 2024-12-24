package com.example.demo.service;

import com.example.demo.dao.UsersDAO;
import com.example.demo.exception.UsernameExistsException;
import com.example.demo.model.AddUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    public void addUser(AddUser user) throws UsernameExistsException {
        usersDAO.insertUser(user);
    }
}
