package com.lagou.edu.controller;


import com.lagou.edu.pojo.QueryVo;
import com.lagou.edu.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

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

    /**
     * SpringMVC在handler方法上传入Map、Model和ModelMap参数，并向这些参数中保存数据（放入到请求域），
     * 都可以在页面获取到
     *
     * 它们之间是什么关系？
     * 运行时的具体类型都是BindingAwareModelMap，相当于给BindingAwareModelMap中保存的数据都会放在请求域中
     *
     *  Map(jdk中的接口)        Model（spring的接口）
     *
     *  ModelMap(class,实现Map接口)
     *
     *
     *
     *
     * BindingAwareModelMap继承了ExtendedModelMap，ExtendedModelMap继承了ModelMap,实现了Model接口
     *
     */
    //url: http://localhost:8080/demo/handle11


    /**
     * 直接声明形参ModelMap，封装数据
     * url: http://localhost:8080/demo/handle11
     *
     * =================modelmap:class org.springframework.validation.support.BindingAwareModelMap
     */
    @RequestMapping("/handle11")
    public String handle11(ModelMap modelMap) {
        Date date = new Date();//服务器时间
        //返回服务器时间到前端页面
        //封装了数据和页面信息的模型
        modelMap.addAttribute("date", date);
        System.out.println("=================modelmap:" + modelMap.getClass());
        return "success";
    }

    /**
     * 直接声明形参Model，封装数据
     * url: http://localhost:8080/demo/handle12
     * =================model:class org.springframework.validation.support.BindingAwareModelMap
     */
    @RequestMapping("/handle12")
    public String handle12(Model model) {
        Date date = new Date();//服务器时间

        model.addAttribute("date", date);
        System.out.println("=================model:" + model.getClass());
        return "success";
    }
    /**
     * 直接声明形参Map集合，封装数据
     * url: http://localhost:8080/demo/handle13
     * =================map:class org.springframework.validation.support.BindingAwareModelMap
     */
    @RequestMapping("/handle13")
    public String handle13(Map<String,Object> map) {
        Date date = new Date();//服务器时间

        map.put("date", date);
        System.out.println("=================map:" + map.getClass());
        return "success";
    }
    /**
     *
     * SpringMVC 对原生servlet api的支持  url：/demo/handle02?id=1
     *
     * 如果要在SpringMVC中使用servlet原生对象，比如HttpServletRequest\HttpServletResponse\HttpSession，直接在Handler方法形参中声明使用即可
     *
     */
    @RequestMapping("/handle02")
    public ModelAndView handle02(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String id = request.getParameter("id");

        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /*
     * SpringMVC 接收简单数据类型参数  url：/demo/handle03?id=1
     *
     * 注意：接收简单数据类型参数，直接在handler方法的形参中声明即可，框架会取出参数值然后绑定到对应参数上
     * 要求：传递的参数名和声明的形参名称保持一致
     */
    @RequestMapping("/handle03")
    public ModelAndView handle03(@RequestParam("ids") Integer id,Boolean flag) {

        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /*
     * SpringMVC接收pojo类型参数  url：/demo/handle04?id=1&username=zhangsan
     *
     * 接收pojo类型参数，直接形参声明即可，类型就是Pojo的类型，形参名无所谓
     * 但是要求传递的参数名必须和Pojo的属性名保持一致
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04(User user) {

        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /*
     * SpringMVC接收pojo包装类型参数  url：/demo/handle05?user.id=1&user.username=zhangsan
     * 不管包装Pojo与否，它首先是一个pojo，那么就可以按照上述pojo的要求来
     * 1、绑定时候直接形参声明即可
     * 2、传参参数名和pojo属性保持一致，如果不能够定位数据项，那么通过属性名 + "." 的方式进一步锁定数据
     *
     */
    @RequestMapping("/handle05")
    public ModelAndView handle05(QueryVo queryVo) {

        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /**
     * 绑定日期类型参数
     * 定义一个SpringMVC的类型转换器  接口，扩展实现接口接口，注册你的实现
     * @param birthday
     * @return
     */
    @RequestMapping("/handle06")
    public ModelAndView handle06(Date birthday) {
        Date date = new Date();ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }



    /*
     * restful  get   /demo/handle/15
     */
    @RequestMapping(value = "/handle/{id}",method = {RequestMethod.GET})
    public ModelAndView handleGet(@PathVariable("id") Integer id) {

        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
