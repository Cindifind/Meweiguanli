package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.Visitor;
import com.example.demo.model.VisitorRequest;
import com.example.demo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        Visitor visitor = new Visitor(request.getName(), request.getReason());
        visitorService.addVisitor(visitor);

        return Result.ADD_VISITOR_SUCCESS;
    }

    @PostMapping("/api/remove-visitor")
    public Result removeVisitorById(@Param(value = "id") int id) {
        return visitorService.removeVisitorById(id);
    }

    @PostMapping("/api/remove-visitor-name")
    public Result removeVisitorByName(@Param(value = "name") String name) {
        return visitorService.removeVisitorsByName(name);
    }

    @PostMapping("/api/query-visitor")
    public Result queryVisitor(@Param(value = "id") int id) {
        return visitorService.getVisitor(id, false);
    }

    @PostMapping("/api/query-visitor-all")
    public Result queryVisitors() {
        return visitorService.getVisitors(false);
    }
}