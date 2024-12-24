package com.example.demo.dao;

import com.example.demo.model.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorDAOImpl implements VisitorDAO {

    private static final Logger logger = LoggerFactory.getLogger(VisitorDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitors (name, reason, del, created_at, carid, phonenum, nameid, department_name, request_at, openid, approve) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    visitor.getName(),
                    visitor.getReason(),
                    visitor.getDel(),
                    visitor.getCreated_at(),
                    visitor.getCarID(),
                    visitor.getPhonenum(),
                    visitor.getNameId(),
                    visitor.getDepartment_name(),
                    visitor.getRequest_at(),
                    visitor.getOpenid(),
                    0 // approve 默认值为 0
            );

            if (rowsAffected > 0) {
                logger.info("数据插入成功，访客姓名: {}", visitor.getName());
            } else {
                logger.warn("数据插入失败，访客姓名: {}", visitor.getName());
            }
        } catch (Exception e) {
            logger.error("插入访客数据时发生异常，访客姓名: {}", visitor.getName(), e);
        }
    }
}
