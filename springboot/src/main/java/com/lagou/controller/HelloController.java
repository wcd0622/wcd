package com.lagou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于配置了Responserbody+@Controller
public class HelloController {

    @RequestMapping("/demo")
    public String demo() {
        return "你好springboot";
    }
}
