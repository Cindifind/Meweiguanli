package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdController {

    private String adJson = "{\"message\": \"恭喜你成功获取到api\"}";

    // 获取广告
    @GetMapping("/GetAd")
    public ResponseEntity<String> getAD() {
        return ResponseEntity.ok(adJson);
    }
    // 修改广告
    @PutMapping("/SetAd")
    public ResponseEntity<Void> setAD(@RequestBody String adJson) {
        this.adJson = adJson;
        return ResponseEntity.noContent().build();
    }
}
