package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    // 处理 GET 请求
    @GetMapping("/example")
    public String example() {
        logger.info("Handling request for /api/example");
        // 处理业务逻辑
        return "Example Response";
    }

}
