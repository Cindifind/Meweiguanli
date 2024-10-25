package com.example.demo.dao;

import com.example.demo.model.Visitor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class VisitorDAOImpl implements VisitorDAO {

    private static final String URL = "jdbc:mysql://124.221.75.56:3306/text";
    private static final String USER = "text";
    private static final String PASSWORD = "Asdf1342.";

    @Override
    public void insertVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitors (name, reason) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, visitor.getName());
            preparedStatement.setString(2, visitor.getReason());

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
