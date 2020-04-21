package com.lagou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lagou.mapper")
@SpringBootApplication
public class Springboot03DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03DataApplication.class, args);
    }

}
