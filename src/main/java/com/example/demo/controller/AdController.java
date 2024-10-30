package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String adJson = "{\"message\": \"恭喜你成功获取到api\"}";

    @GetMapping("/GetAd")
    public ResponseEntity<String> getAD() {
        return ResponseEntity.ok(adJson);
    }

    @PutMapping("/SetAd")
    public ResponseEntity<Void> setAD(@RequestBody String adJson) {
        this.adJson = adJson;
        return ResponseEntity.noContent().build();

    }
}
