package com.example.demo.dao;

import com.example.demo.model.Visitor;
import com.example.demo.util.ManageConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class VisitorDAOImpl implements VisitorDAO {
    @Override
    public void insertVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitors (name, reason, del, created_at, carid,phonenum,nameid,college,request_at) VALUES (?, ?, ?, ?, ? ,?,?,?,?)";
        try {
            Connection connection = ManageConnection.getConnection();
            if (connection == null) {
                System.err.println("无法获取数据库连接");
                return;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, visitor.getName());
            preparedStatement.setString(2, visitor.getReason());
            preparedStatement.setString(3, visitor.getDel());
            preparedStatement.setString(4, visitor.getCreated_at());
            preparedStatement.setString(5, visitor.getCarID());
            preparedStatement.setString(6, visitor.getPhonenum());
            preparedStatement.setString(7, visitor.getNameId());
            preparedStatement.setString(8, visitor.getCollege());
            preparedStatement.setString(9, visitor.getRequest_at());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("数据插入成功");
            } else {
                System.out.println("数据插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
