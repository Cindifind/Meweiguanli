package com.example.demo.dao;

import com.example.demo.exception.UsernameExistsException;
import com.example.demo.model.AddUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private final JdbcTemplate jdbcTemplate;

    public UsersDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUser(AddUser user) throws UsernameExistsException {
        String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users (username, password, enabled, department_name, user, level) VALUES (?, ?, ?, ?, ?, ?)";

        // Check if the username already exists
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, user.getUsername());
        if (count > 0) {
            throw new UsernameExistsException("用户名已存在");
        }

        // Insert the new user
        int rowsAffected = jdbcTemplate.update(insertSql,
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getDepartment_name(),
                user.getUser(),
                user.getLevel());

        if (rowsAffected <= 0) {
            throw new RuntimeException("数据插入失败");
        }
    }
}