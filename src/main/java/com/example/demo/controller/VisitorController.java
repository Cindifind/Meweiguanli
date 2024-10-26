package com.example.demo.controller;

import com.example.demo.dao.VisitorDAO;
import com.example.demo.model.Visitor;
import com.example.demo.model.VisitorRequest;
import com.example.demo.model.VisitorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层 访客登录类，用于访客登录调用
 */
@RestController
public class VisitorController {

    private final VisitorDAO visitorDAO;

    public VisitorController(VisitorDAO visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    /**
     * 添加访客
     */
    @PostMapping("/api/visitor")
    public VisitorResponse addVisitor(@RequestBody VisitorRequest request) {
        Visitor visitor = new Visitor(request.getName(), request.getReason());
        visitorDAO.insertVisitor(visitor);

        VisitorResponse response = new VisitorResponse();
        response.setStatus("success");
        response.setMessage("数据插入成功");
        response.setData(visitor);

        return response;
    }
}