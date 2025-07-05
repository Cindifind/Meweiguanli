package com.example.demo.dao;

import com.example.demo.model.UserAuthorities;

public interface UserAuthoritiesDAO {
    void insertUserAuthorities(UserAuthorities userAuthorities);
    void deleteUserAuthorities(int id);
}
