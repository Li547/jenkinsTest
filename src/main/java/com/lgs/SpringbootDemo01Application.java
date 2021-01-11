package com.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lgs.dao")
public class SpringbootDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo01Application.class, args);
    }

}
