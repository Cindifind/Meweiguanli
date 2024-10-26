package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import com.example.demo.util.ResultConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @DeleteMapping("/api/example/{id}")
    public ResultConst deleteVisitor(@PathVariable("id") int id) {
        exampleService.updateDelValue(id);
        return ResultConst.success();
    }
}
