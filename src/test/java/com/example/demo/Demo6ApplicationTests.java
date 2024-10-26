package com.example.demo;

import com.example.demo.dao.VisitorDAOImpl;
import com.example.demo.model.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo6ApplicationTests {

    @Autowired
    VisitorDAOImpl visitorDAO;

    @Test
    public void selectAllTest() {
        List<Visitor> visitors = visitorDAO.selectAll();
        visitors.forEach(System.out::println);
    }

    @Test
    public void insertTest() {
        visitorDAO.insertVisitor(new Visitor("张三", "测试"));
    }

    @Test
    public void deleteTest() {
        System.out.println(visitorDAO.deleteByName("张三"));
    }

    @Test
    public void selectById() {
        System.out.println(visitorDAO.selectById(22));
    }
}
