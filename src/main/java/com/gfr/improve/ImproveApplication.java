package com.gfr.improve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.gfr.improve.dao")
@EnableTransactionManagement
public class ImproveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImproveApplication.class, args);
    }

}
