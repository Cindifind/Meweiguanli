package com.example.demo.service;

import com.example.demo.dao.UserAuthoritiesDAOImpl;
import com.example.demo.model.UserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private UserAuthoritiesDAOImpl userAuthoritiesDAOImpl;

    public AuthorityService() {
        // 默认构造函数
    }

    public void addUserAuthorities(UserAuthorities userAuthorities) {
        userAuthoritiesDAOImpl.insertUserAuthorities(userAuthorities);
    }
    public void deleteUserAuthorities(int userId) {
        userAuthoritiesDAOImpl.deleteUserAuthorities(userId);
    }
}
