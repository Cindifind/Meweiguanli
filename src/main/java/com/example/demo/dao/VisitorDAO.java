package com.example.demo.dao;

import com.example.demo.model.Visitor;

import java.util.List;

public interface VisitorDAO {
    /**
     * 插入一条访客
     *
     * @param visitor 插入的用户对象
     */
    void insertVisitor(Visitor visitor);


    /**
     * @param id 根据ID删除访客
     * @return 返回成功还是失败
     */
    Boolean deleteById(int id);

    /**
     * @param name 根据名称删除访客
     * @return 返回成功或者失败
     */
    Boolean deleteByName(String name);

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

    /**
     * @param id 根据ID查询访客不包含Del等于1的访客
     * @return 返回用户
     */
    Visitor selectByIdNotDel(int id);

    /**
     * 返回所有访客不包含Del等于1的访客
     *
     * @return 所有用户
     */
    List<Visitor> selectAllNotDel();
}
