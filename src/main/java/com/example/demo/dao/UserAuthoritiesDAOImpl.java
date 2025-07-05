package com.example.demo.dao;

import com.example.demo.model.UserAuthorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthoritiesDAOImpl implements UserAuthoritiesDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthoritiesDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertUserAuthorities(UserAuthorities userAuthorities) {
        String sql = "INSERT INTO user_authorities (user_id, authority_id) VALUES (?, ?)";
        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    userAuthorities.getUserId(),
                    userAuthorities.getAuthorityId() + 1 // 注意这里增加了 1，确保符合业务需求
            );

            if (rowsAffected > 0) {
                logger.info("用户权限插入成功，用户ID: {}, 权限ID: {}", userAuthorities.getUserId(), userAuthorities.getAuthorityId() + 1);
            } else {
                logger.warn("用户权限插入失败，用户ID: {}, 权限ID: {}", userAuthorities.getUserId(), userAuthorities.getAuthorityId() + 1);
            }
        } catch (Exception e) {
            logger.error("插入用户权限时发生异常，用户ID: {}, 权限ID: {}", userAuthorities.getUserId(), userAuthorities.getAuthorityId() + 1, e);
        }
    }
    @Override
    public void deleteUserAuthorities(int id) {
        String sql = "DELETE FROM user_authorities WHERE user_id = ? ";
        try {
            int rowsAffected = jdbcTemplate.update(sql,id);

            if (rowsAffected > 0) {
                logger.info("用户权限删除成功，用户ID: {}", id);
            }
        }catch (Exception e){
            logger.error("删除用户权限时发生异常，用户ID: {}", id, e);
        }
    }
}
