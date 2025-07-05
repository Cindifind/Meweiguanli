package com.example.demo.controller;

import com.example.demo.model.UserAuthorities;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.ExampleService;
import com.example.demo.service.VisitorDataService;
import com.example.demo.util.ResultConst;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;
    private final AuthorityService authorityService;
    private final VisitorDataService visitorDataService;

    public ExampleController(ExampleService exampleService, AuthorityService authorityService, VisitorDataService visitorDataService) {
        this.exampleService = exampleService;
        this.authorityService = authorityService;
        this.visitorDataService = visitorDataService;
    }

    //一级审批同意
    @PutMapping("/api/approve1T/{id}")
    public ResultConst updateApproveFalse1(@PathVariable("id") int id) {
        visitorDataService.updateApproveValueTById(id, 1);
        return ResultConst.success();
    }
    //二级审批同意
    @PutMapping("/api/approve2T/{id}")
    public ResultConst updateApproveFalse2(@PathVariable("id") int id) {
        visitorDataService.updateApproveValueTById(id, 3);
        return ResultConst.success();
    }
    //一审批不同意
    @PutMapping("/api/approve1F/{id}")
    public ResultConst updateApproveTure1(@PathVariable("id") int id) {
        visitorDataService.updateApproveValueTById(id, 0);
        return ResultConst.success();
    }
    //二审批不同意
    @PutMapping("/api/approve2F/{id}")
    public ResultConst updateApproveTure2(@PathVariable("id") int id) {
        visitorDataService.updateApproveValueTById(id, 1);
        return ResultConst.success();
    }
    //删除访客
    @PutMapping("/api/del/{id}")
    public ResultConst updateDelFalse(@PathVariable("id") int id) {
        visitorDataService.updateDelValueTById(id);
        return ResultConst.success();
    }
    //启用管理员
    @PutMapping("/api/enabledT/{id}/{level}")
    public ResultConst updateEnabledToTrue(@PathVariable("id") int id,@PathVariable("level") int level) {
        exampleService.updateEnabledValue(id, 1);
        UserAuthorities userAuthorities = new UserAuthorities(id, level);
        authorityService.addUserAuthorities(userAuthorities);
        return ResultConst.success();
    }
    @PutMapping("/api/enabledF/{id}")
    public ResultConst updateEnabledToFalse(@PathVariable("id") int id) {
        exampleService.updateEnabledValue(id, 0);
        authorityService.deleteUserAuthorities(id);
        return ResultConst.success();
    }
    //删除管理员
    @DeleteMapping("/api/delUsers/{id}")
    public ResultConst deleteUser(@PathVariable("id") int id) {
        exampleService.deleteUserById(id);
        return ResultConst.success();
    }

}
