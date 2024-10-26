package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 获取mysql数据库连接,如果每次插入或访问数据库都要建立连接,那样效率很底下,可以先创建好一个连接然后在用的时候直接调用就好了
 *
 * @author AfeiB
 * {@code @date}2024/10/26 下午1:04
 */

public class ManageConnection {

    private static final String URL = "jdbc:mysql://124.221.75.56:3306/text";
    private static final String USER = "text";
    private static final String PASSWORD = "Asdf1342.";

    private static Connection connection;

    /**
     * 获取当前数据库连接
     *
     * @return 返回数据库连接
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
}