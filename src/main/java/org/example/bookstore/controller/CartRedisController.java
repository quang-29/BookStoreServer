package org.example.bookstore.controller;

import lombok.Getter;
import org.example.bookstore.service.Interface.BaseRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartRedisController {

    private final BaseRedisService<String,String,String> baseRedisService;

    public CartRedisController(BaseRedisService<String, String, String> baseRedisService) {
        this.baseRedisService = baseRedisService;
    }

    @GetMapping("")
    public String cart() {
        baseRedisService.set("redis", "quang");
        return "cart";
    }
}
