package com.example.demo.dao;

import com.example.demo.model.Visitor;

import java.util.List;

public interface VisitorDAO {
    void insertVisitor(Visitor visitor);


    /**
     * @param id 根据ID删除访客
     * @return 返回成功还是失败
     */
    Boolean deleteById(int id);

    /**
     * @param id 根据ID查询访客
     * @return 返回用户
     */
    Visitor selectById(int id);

    /**
     * 返回所有访客
     *
     * @return 所有用户
     */
    List<Visitor> selectAll();
}
