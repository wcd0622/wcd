package com.lagou.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/handle01")
    public ModelAndView handle01() {
        Date date = new Date();//服务器时间
        //返回服务器时间到前端页面
        //封装了数据和页面信息的模型
        ModelAndView modelAndView = new ModelAndView();
        //addObject向请求域中request.setattribute("date",date);
        modelAndView.addObject("date",date);
        //视图信息（封装跳转的页面信息）
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
