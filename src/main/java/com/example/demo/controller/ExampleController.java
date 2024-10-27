package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import com.example.demo.util.ResultConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @DeleteMapping("/api/del/{id}")
    public ResultConst deleteVisitor(@PathVariable("id") int id) {
        exampleService.updateDelValue(id);
        return ResultConst.success();
    }

    @PutMapping("/api/gaT/{id}")
    public ResultConst updateGaToTrue(@PathVariable("id") int id) {
        exampleService.updateGaValue(id, 0);
        return ResultConst.success();
    }

    @PutMapping("/api/gaF/{id}")
    public ResultConst updateGaToFalse(@PathVariable("id") int id) {
        exampleService.updateGaValue(id, 1);
        return ResultConst.success();
    }

    @PutMapping("/api/oaaaT/{id}")
    public ResultConst updateOaaaToTrue(@PathVariable("id") int id) {
        exampleService.updateOaaaValue(id, 0);
        return ResultConst.success();
    }

    @PutMapping("/api/oaaaF/{id}")
    public ResultConst updateOaaaToFalse(@PathVariable("id") int id) {
        exampleService.updateOaaaValue(id, 1);
        return ResultConst.success();
    }
}
