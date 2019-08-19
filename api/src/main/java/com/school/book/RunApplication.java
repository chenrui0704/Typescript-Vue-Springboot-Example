package com.school.book;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 * @author Cr
 * */
@SpringBootApplication
@MapperScan({"com.school.book.dao"})
public class RunApplication {

    public static void main(String[] args) {



        SpringApplication.run(RunApplication.class, args);

    }

}
