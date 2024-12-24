package com.example.demo.dao;

import com.example.demo.model.department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertDepartment(department department) {
        String sql = "INSERT INTO department (department_name, level) VALUES (?, ?)";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    department.getDepartment_name(), // 假设 getter 方法为 getDepartmentName()
                    department.getLevel()
            );
            if (rowsAffected > 0) {
                logger.info("数据插入成功，部门名称: {}", department.getDepartment_name());
            } else {
                logger.warn("数据插入失败，部门名称: {}", department.getDepartment_name());
            }
        } catch (Exception e) {
            logger.error("插入部门数据时发生异常，部门名称: {}", department.getDepartment_name(), e);
        }
    }
}
