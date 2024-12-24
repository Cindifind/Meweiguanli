package com.example.demo.controller;


import com.example.demo.model.DataEntity;
import com.example.demo.model.User;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.service.DataService;
import com.example.demo.service.VisitorDataService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;
    private final VisitorDataService visitorDataService;

    public DataController(DataService dataService, VisitorDataService visitorDataService) {
        this.dataService = dataService;
        this.visitorDataService = visitorDataService;
    }

    // 查询所有用户
    @GetMapping("/FindUser")
    public List<User> getUsers() {
        return dataService.findUsers();
    }
    // 查询所有访客
    @GetMapping("/FindVisitor")
    public List<DataEntity> getVisitors(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return visitorDataService.findVisitorData(userDetails.getUser().getDepartment_name(), userDetails.getUser().getLevel());
    }
    //查找固定访客
    @GetMapping("/FindVisitorByOpenId")
    public List<DataEntity> getVisitorsByOpenId(String openid) {
        return visitorDataService.findByOpenidAndDel(openid);
    }
}

