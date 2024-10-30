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

    @GetMapping("/InforC")
    public List<DataEntity> getInforCData() {
        return dataService.findInforCData();
    }
    @GetMapping("/Concierge")
    public List<DataEntity> getConciergeData() {
        return dataService.findConciergeData();
    }
    @GetMapping("/FACC")
    public List<DataEntity> getActiveData() {
        return dataService.findFACCData();
    }
    @GetMapping("/HumanC")
    public List<DataEntity> getHumanCData() {
        return dataService.findHumanCData();
    }
    @GetMapping("/GeneralC")
    public List<DataEntity> getGeneralCData() {
        return dataService.findGeneralCData();
    }
}

