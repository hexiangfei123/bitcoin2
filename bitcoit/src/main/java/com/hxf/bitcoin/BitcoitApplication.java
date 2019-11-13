package com.hxf.bitcoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hxf.bitcoin.dao")
@EnableScheduling
public class BitcoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoitApplication.class, args);
    }

}
