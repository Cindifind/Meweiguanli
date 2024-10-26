package com.example.demo.dao;

import com.example.demo.model.Visitor;
import com.example.demo.util.ManageConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VisitorDAOImpl implements VisitorDAO {


    /**
     * 插入访客到数据库
     *
     * @param visitor 插入的对象
     */
    @Override
    public void insertVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitors (name, reason) VALUES (?, ?)";
        try {
            Connection connection = ManageConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

    /**
     * 根据Id删除（设置DEL值等于1）
     *
     * @param id 根据ID删除访客
     * @return 返回成功还是失败
     */
    @Override
    public Boolean deleteById(int id) {
        //sql
        String sql = "update visitors set DEL = 1 where id = ?";
        //获取连接
        Connection connection = ManageConnection.getConnection();
        try {
            //传入sql
            PreparedStatement statement = connection.prepareStatement(sql);
            //设置参数
            statement.setInt(1, id);
            //返回成功还是失败
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @return 返回所有访客 包括 del=1
     */
    @Override
    public List<Visitor> selectAll() {
        return List.of();
    }
    /**
     * 根据id查询访客信息
     *
     * @param id 根据ID查询访客
     * @return 返回访客对象
     */
    @Override
    public Visitor selectById(int id) {
        String sql = "select * from visitors where id = ?";
        Connection connection = ManageConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Visitor(resultSet.getString("name"), resultSet.getString("reason"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
