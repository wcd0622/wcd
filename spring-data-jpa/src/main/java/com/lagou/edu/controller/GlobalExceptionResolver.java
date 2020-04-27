package com.lagou.edu.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

//可以优雅的让我们捕获所有controller对象handler方法抛出的异常
@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ModelAndView handleException(ArithmeticException exception, HttpServletResponse response) {
        //异常处理逻辑
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
}}
