package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.Visitor;
import com.example.demo.model.VisitorRequest;
import com.example.demo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层 访客登录类，用于访客登录调用
 */
@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    /**
     * 添加访客
     */
    @PostMapping("/api/visitor")
    public Result addVisitor(@RequestBody VisitorRequest request) {
        Visitor visitor = new Visitor(request.getName(), request.getReason(),request.getCarID(),request.getPhonenum());
        visitorService.addVisitor(visitor);

        return Result.ADD_VISITOR_SUCCESS;
    }

}