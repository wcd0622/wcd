package com.lagou.config;

import com.lagou.pojo.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@ConditionalOnClass(SimpleBean.class)//注解：当类路径classpath下有指定的类情况，就会进行自动配置
public class MyAutoConfiguration {
    static {
        System.out.println("MyAutoConfiguration init....");
    }
@Bean
    public SimpleBean simpleBean() {

        return new SimpleBean();
    }
}
