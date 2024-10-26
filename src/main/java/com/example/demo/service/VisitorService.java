package com.example.demo.service;

import com.example.demo.dao.VisitorDAOImpl;
import com.example.demo.model.Result;
import com.example.demo.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 逻辑层 访客逻辑编写类
 *
 * @author AfeiB
 * {@code @date}2024/10/26 下午12:58
 */

@Service
public class VisitorService {
    @Autowired
    VisitorDAOImpl visitorDAO;

    public void addVisitor(Visitor visitor) {
        visitorDAO.insertVisitor(visitor);
    }

    /**
     * @param id          查询的id
     * @param containsDel 是否包含del=1数据，如果是true 就是包含del=1的数据
     */
    public Result getVisitor(int id, boolean containsDel) {
        Visitor visitor;
        if (containsDel) {
            visitor = visitorDAO.selectById(id);
        } else {
            visitor = visitorDAO.selectByIdNotDel(id);
        }
        if (visitor == null) {
            return Result.VISITOR_NOT_EXIST_ERROR;
        }
        return Result.QUERY_VISITOR_SUCCESS.setObject(visitor);
    }

    /**
     * @param containsDel 是否包含del=1的数据
     */
    public Result getVisitors(boolean containsDel) {
        List<Visitor> visitors;
        if (containsDel) {
            visitors = visitorDAO.selectAll();
        } else {
            visitors = visitorDAO.selectAllNotDel();
        }
        return Result.BATCH_QUERY_VISITOR_SUCCESS.setObject(visitors);
    }

    /**
     * @param id 根据id删除访客
     */
    public Result removeVisitorById(int id) {
        return visitorDAO.deleteById(id) ? Result.REMOVE_VISITOR_SUCCESS : Result.REMOVE_VISITOR_ERROR;
    }

    /**
     * @param name 根据名称删除访客
     */
    public Result removeVisitorsByName(String name) {
        return visitorDAO.deleteByName(name) ? Result.REMOVE_VISITOR_SUCCESS : Result.REMOVE_VISITOR_ERROR;
    }
}
