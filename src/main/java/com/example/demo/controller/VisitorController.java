package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {

    private final VisitorService visitorService;


    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // 添加访客
    @PostMapping("/api/visitor")
    public Result addVisitor(@RequestBody Visitor request) {
        Visitor visitor = new Visitor(request.getName(), request.getReason(),request.getCarID(),request.getPhonenum(),request.getNameId(),request.getRequest_at(),request.getDepartment_name(),request.getOpenid());
        visitorService.addVisitor(visitor);
        return Result.SUCCESS;
    }
}