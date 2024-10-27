package com.example.demo.dao;

import com.example.demo.model.Visitor;

public interface VisitorDAO {
    /**
     * 插入一条访客
     *
     * @param visitor 插入的用户对象
     */
    void insertVisitor(Visitor visitor);

}
