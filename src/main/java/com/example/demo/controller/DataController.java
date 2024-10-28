package com.example.demo.controller;

import com.example.demo.model.DataEntity;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/activeOAAA")
    public List<DataEntity> getOAAAData() {
        return dataService.findActiveData();
    }
    @GetMapping("/activeGA")
    public List<DataEntity> getGAData() {
        return dataService.findActive1Data();
    }
}

